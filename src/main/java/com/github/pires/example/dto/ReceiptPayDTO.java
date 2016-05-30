package com.github.pires.example.dto;

import com.github.pires.example.model.Receipt;

/**
 * Created by bastiangardel on 18.05.16.
 */
public class ReceiptPayDTO {
    private Double amount;
    private Long id;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReceiptPayDTO modelToDto(Receipt receipt)
    {
        amount = receipt.getAmount();
        id = receipt.getId();

        return this;
    }
}
