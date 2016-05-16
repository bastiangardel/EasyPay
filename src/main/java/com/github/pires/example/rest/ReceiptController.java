package com.github.pires.example.rest;

import com.github.pires.example.model.CheckOut;
import com.github.pires.example.model.Receipt;
import com.github.pires.example.repository.CheckOutRepository;
import com.github.pires.example.repository.ReceiptRepository;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by bastiangardel on 16.05.16.
 */
@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    private static final Logger log = LoggerFactory.
            getLogger(UserController.class);


    @Autowired
    private ReceiptRepository receiptRepo;

    @Autowired
    private CheckOutRepository checkOutRepo;

    @RequestMapping(method = POST)
    @RequiresAuthentication
    @RequiresRoles("SELLER")
    public void create(@RequestBody Long amount, @RequestBody String UUIDCheckOut) {
        log.info("create new Receipt {}");

        CheckOut checkOut = checkOutRepo.findByUUID(UUIDCheckOut);

        Receipt r = new Receipt();

        receiptRepo.save(r);

    }
}
