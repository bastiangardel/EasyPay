package com.github.pires.example.rest;

import com.github.pires.example.Exception.CheckOutNotFoundException;
import com.github.pires.example.Exception.UUIDAlreadyInUseException;
import com.github.pires.example.Exception.UserNotFoundException;
import com.github.pires.example.dto.CheckOutCreationDTO;
import com.github.pires.example.dto.SuccessMessageDTO;
import com.github.pires.example.model.CheckOut;
import com.github.pires.example.model.User;
import com.github.pires.example.repository.CheckOutRepository;
import com.github.pires.example.repository.UserRepository;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
        }catch (ArrayIndexOutOfBoundsException e) {
            throw new UserNotFoundException("Not found User with Username : " + email);
        }

        try {
            checkOut = checkoutRepo.findByUuid(checkOutCreationDTO.getUuid());
        }catch (ArrayIndexOutOfBoundsException e) {


            checkOut = checkoutRepo.save(checkOutCreationDTO.dtoToModel(user));

            List<CheckOut> list = user.getCheckoutInPossesion();

            list.add(checkOut);

            user.setCheckoutInPossesion(list);

            userRepo.save(user);

            return new SuccessMessageDTO("Creation with Success");
        }



        throw new UUIDAlreadyInUseException("UUID " + checkOutCreationDTO.getUuid() + " already in use");
    }


    @RequestMapping(method = GET)
    @RequiresAuthentication
    @RequiresRoles("ADMIN")
    public List<CheckOut> getAll() {
        log.info("getAll Checkouts {}");

        return checkoutRepo.findAll();
    }
}
