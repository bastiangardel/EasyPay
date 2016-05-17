package com.github.pires.example.dto;

import com.github.pires.example.model.Receipt;

import java.util.Date;

/**
 * Created by bastiangardel on 18.05.16.
 */
public class ReceiptCreationDTO {

    private String uuidCheckout;
    private Long amount;

    public Receipt dtoToModel()
    {
        Receipt tmp = new Receipt();


        tmp.setAmount(amount);
        tmp.setIspaid(false);

        tmp.setCreated(new Date());
        return tmp;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getUuidCheckout() {
        return uuidCheckout;
    }

    public void setUuidCheckout(String uuidCheckout) {
        this.uuidCheckout = uuidCheckout;
    }
}
