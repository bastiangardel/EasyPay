package com.github.pires.example.rest;

import com.github.pires.example.Exception.CheckOutNotFoundException;
import com.github.pires.example.Exception.ReceiptAlreadyPayExeption;
import com.github.pires.example.dto.ReceiptCreationDTO;
import com.github.pires.example.dto.ReceiptPayDTO;
import com.github.pires.example.dto.SuccessMessageDTO;
import com.github.pires.example.model.CheckOut;
import com.github.pires.example.model.Receipt;
import com.github.pires.example.repository.CheckOutRepository;
import com.github.pires.example.repository.ReceiptRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by bastiangardel on 16.05.16.
 */
@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    private static final Logger log = LoggerFactory.
            getLogger(ReceiptController.class);

    @Autowired
    private ReceiptRepository receiptRepo;

    @Autowired
    private CheckOutRepository checkOutRepo;

    @RequestMapping(method = POST)
    @RequiresAuthentication
    @RequiresRoles("SELLER")
    public SuccessMessageDTO create(@RequestBody ReceiptCreationDTO receiptCreationDTO){
        log.info("create new Receipt {}");

        CheckOut checkOut = checkOutRepo.findByUuid(receiptCreationDTO.getUuidCheckout());



        if(checkOut == null)
            throw new EntityNotFoundException("Not found CheckOut with UUID : " + receiptCreationDTO.getUuidCheckout());

        final Subject subject = SecurityUtils.getSubject();

        if(checkOut.getOwner().getEmail() != subject.getSession().getAttribute("email"))
            throw new UnauthorizedException("Your not the owner of this checkout");

        List<Receipt> list = checkOut.getReceiptsHistory();

        Receipt receipt = receiptRepo.save(receiptCreationDTO.dtoToModel());

        list.add(receipt);

        checkOut.setReceiptsHistory(list);

        return new SuccessMessageDTO("Creation with Success");
    }

    @RequestMapping(value = "/pay", method = GET)
    @RequiresAuthentication
    public ReceiptPayDTO getReceiptToPay(@RequestParam("uuid") String uuid){

        log.info("Get Receipt from checkOut : {}", uuid);

        CheckOut checkOut;

        try {
            checkOut = checkOutRepo.findByUuid(uuid);
        }catch (IndexOutOfBoundsException e){
            throw new CheckOutNotFoundException("Not Found CheckOut with UUID : " + uuid);
        }

        ReceiptPayDTO receiptPayDTO = new ReceiptPayDTO();

        List<Receipt> list = checkOut.getReceiptsHistory();

        list.sort((o1, o2) -> o2.getCreated().compareTo(o1.getCreated()));

        Receipt receipt = list.get(0);

        if (receipt.ispaid())
            throw new ReceiptAlreadyPayExeption("Receipt with id : " + receipt.getId() + " already pay");

        return  receiptPayDTO.modelToDto(receipt);

    }


    @RequestMapping(value = "/isPay", method = GET)
    @RequiresAuthentication
    @RequiresRoles("SELLER")
    public Boolean lastReceiptIsPay(@RequestParam("uuid") String uuid){

        log.info("Verfify last receipt from checkOut {} is pay", uuid);

        CheckOut checkOut;

        final Subject subject = SecurityUtils.getSubject();

        try {
            checkOut = checkOutRepo.findByUuid(uuid);
        }catch (IndexOutOfBoundsException e){
            throw new CheckOutNotFoundException("Not found CheckOut with UUID : " + uuid);
        }

        if(checkOut.getOwner().getEmail() != subject.getSession().getAttribute("email"))
            throw new UnauthorizedException("Your not the owner of this checkout");

        List<Receipt> list = checkOut.getReceiptsHistory();

        Receipt receipt = list.get(0);

        return  receipt.ispaid();
    }

    @RequestMapping(value = "/pay", method = POST)
    @RequiresAuthentication
    public SuccessMessageDTO paiement(@RequestBody ReceiptPayDTO receiptPayDTO){
        log.info("PayReceipt : {}", receiptPayDTO.getId());


        Receipt receipt = receiptRepo.findOne(receiptPayDTO.getId());



        return new SuccessMessageDTO("Creation with Success");

    }

}
