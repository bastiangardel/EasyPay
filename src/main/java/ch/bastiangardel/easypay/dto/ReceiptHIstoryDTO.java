package ch.bastiangardel.easypay.dto;

import ch.bastiangardel.easypay.model.Receipt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by bastiangardel on 27.06.16.
 */
public class ReceiptHistoryDTO {
    private Double amount;
    private Long id;
    private String payBy;
    private String created;

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

    public String getPayBy() {
        return payBy;
    }

    public void setPayBy(String payBy) {
        this.payBy = payBy;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public ReceiptHistoryDTO modelToDto(Receipt receipt) {
        amount = receipt.getAmount();
        id = receipt.getId();
        payBy = receipt.getPaiyedBy().getName();

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        created  = df.format(receipt.getCreated());

        return this;
    }

}
