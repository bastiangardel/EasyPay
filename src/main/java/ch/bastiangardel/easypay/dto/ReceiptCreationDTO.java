package ch.bastiangardel.easypay.dto;

import ch.bastiangardel.easypay.model.Receipt;

/**
 * Created by bastiangardel on 18.05.16.
 */
public class ReceiptCreationDTO {

    private String uuidCheckout;
    private Double amount;

    public Receipt dtoToModel()
    {
        Receipt tmp = new Receipt();


        tmp.setAmount(amount);
        tmp.setPaid(false);

        //tmp.setCreated(new Date());
        return tmp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUuidCheckout() {
        return uuidCheckout;
    }

    public void setUuidCheckout(String uuidCheckout) {
        this.uuidCheckout = uuidCheckout;
    }
}
