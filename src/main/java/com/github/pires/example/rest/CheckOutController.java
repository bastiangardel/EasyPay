package com.github.pires.example.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.pires.example.exception.UUIDAlreadyInUseException;
import com.github.pires.example.exception.UserNotFoundException;
import com.github.pires.example.dto.CheckOutCreationDTO;
import com.github.pires.example.dto.SuccessMessageDTO;
import com.github.pires.example.model.CheckOut;
import com.github.pires.example.model.User;
import com.github.pires.example.repository.CheckOutRepository;
import com.github.pires.example.repository.UserRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by bastiangardel on 16.05.16.
 */
@RestController
@RequestMapping("/checkouts")
public class CheckOutController {

    private static final Logger log = LoggerFactory.
            getLogger(CheckOutController.class);

    @Autowired
    private UserRepository userRepo;


    @Autowired
    private CheckOutRepository checkoutRepo;

    @RequestMapping(method = POST)
    @RequiresAuthentication
    @RequiresRoles("ADMIN")
    public SuccessMessageDTO create(@RequestBody CheckOutCreationDTO checkOutCreationDTO) {
        log.info("create new Checkout {}", checkOutCreationDTO.getUuid());

        User user;
        CheckOut checkOut;

        String email = checkOutCreationDTO.getEmail();

        if (email == null)
            email = "";

        try {
             user = userRepo.findByEmail(email);
        }
        catch (IndexOutOfBoundsException e) {
            throw new UserNotFoundException("Not found User with Username : " + email);
        }

        log.info("create new Checkout to user {}", user.getEmail());

        try {
            checkOut = checkoutRepo.findByUuid(checkOutCreationDTO.getUuid());
        }catch (IndexOutOfBoundsException e) {

            List<CheckOut> list = user.getCheckoutInPossesion();

            checkOut = checkoutRepo.save(checkOutCreationDTO.dtoToModel(user));

            list.add(checkOut);

            userRepo.save(user);


            return new SuccessMessageDTO("Creation with Success");
        }


        throw new UUIDAlreadyInUseException("UUID " + checkOutCreationDTO.getUuid() + " already in use");
    }


    @JsonView(View.Summary.class)
    @RequestMapping(method = GET)
    @RequiresAuthentication
    @RequiresRoles("ADMIN")
    public List<CheckOut> getAll() {
        log.info("getAll Checkouts {}");

        return (List) checkoutRepo.findAll();
    }

    @JsonView(View.Summary.class)
    @RequestMapping(value = "/checkoutlist", method = GET)
    @RequiresAuthentication
    public List<CheckOut> getUserCheckOuts() {
        log.info("get User Checkouts {}");
        final Subject subject = SecurityUtils.getSubject();
        String email = (String) subject.getSession().getAttribute("email");

        User user = userRepo.findByEmail(email);

        return user.getCheckoutInPossesion();
    }
}
