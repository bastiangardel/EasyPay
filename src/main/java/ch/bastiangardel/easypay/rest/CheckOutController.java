package ch.bastiangardel.easypay.rest;

import ch.bastiangardel.easypay.dto.CheckOutCreationDTO;
import ch.bastiangardel.easypay.dto.CheckOutSummaryDTO;
import ch.bastiangardel.easypay.dto.SuccessMessageDTO;
import ch.bastiangardel.easypay.exception.*;
import ch.bastiangardel.easypay.model.CheckOut;
import ch.bastiangardel.easypay.model.Receipt;
import ch.bastiangardel.easypay.model.User;
import ch.bastiangardel.easypay.repository.CheckOutRepository;
import ch.bastiangardel.easypay.repository.ReceiptRepository;
import ch.bastiangardel.easypay.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
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


    @Autowired
    private ReceiptRepository receiptRepo;

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

        user = userRepo.findByEmail(email);

        if (user == null)
            throw new UserNotFoundException("Not found User with Username : " + email);


        log.info("create new Checkout to user {}", user.getEmail());

        checkOut = checkoutRepo.findByUuid(checkOutCreationDTO.getUuid());

        if (checkOut == null) {

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

        return (List<CheckOut>) checkoutRepo.findAll();
    }

    @RequestMapping(value = "/checkoutlist", method = GET)
    @RequiresAuthentication
    @RequiresRoles("SELLER")
    public List<CheckOutSummaryDTO> getUserCheckOuts() {
        log.info("get User Checkouts {}");
        final Subject subject = SecurityUtils.getSubject();
        String email = (String) subject.getSession().getAttribute("email");

        User user = userRepo.findByEmail(email);

        List<CheckOutSummaryDTO> list = new LinkedList<>();
        for(CheckOut checkOut : user.getCheckoutInPossesion())
        {
            CheckOutSummaryDTO checkOutSummaryDTO = new CheckOutSummaryDTO();
            checkOutSummaryDTO.modelToDto(checkOut);
            list.add(checkOutSummaryDTO);

        }

        return list;
    }

    @RequestMapping(value = "/receipttopay", method = DELETE)
    @RequiresAuthentication
    @RequiresRoles("SELLER")
    public void deleteLastreceipt(@RequestParam("uuid") String uuid) {
        CheckOut checkOut;


        checkOut = checkoutRepo.findByUuid(uuid);

        if (checkOut == null)
            throw new CheckOutNotFoundException("Not Found CheckOut with UUID : " + uuid);

        final Subject subject = SecurityUtils.getSubject();



        if(!checkOut.getOwner().getEmail().equals(subject.getSession().getAttribute("email")))
            throw new OwnerException("Your are not the owner of this checkout");


        Receipt receipt = checkOut.getLastReceipt();


        if (receipt == null)
            throw new NoReceiptToPayExeption("No Receipt to Delete");




        checkOut.setLastReceipt(null);

        checkoutRepo.save(checkOut);

        receiptRepo.delete(receipt);
    }
}
