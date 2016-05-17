package com.github.pires.example.rest;

import com.github.pires.example.dto.ReceiptCreationDTO;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
    public void create(@RequestBody ReceiptCreationDTO receiptCreationDTO){
        log.info("create new Receipt {}");

        CheckOut checkOut = checkOutRepo.findByUuid(receiptCreationDTO.getUuidCheckout());



        if(checkOut == null)
            throw new EntityNotFoundException("Not found CheckOut with " + receiptCreationDTO.getUuidCheckout());

        final Subject subject = SecurityUtils.getSubject();

        if(checkOut.getOwner().getEmail() != subject.getSession().getAttribute("email"))
            throw new UnauthorizedException("Your not the owner of this checkout");

        List<Receipt> list = checkOut.getReceiptsHistory();

        Receipt receipt = receiptRepo.save(receiptCreationDTO.dtoToModel());

        list.add(receipt);

        checkOut.setReceiptsHistory(list);
    }
}
