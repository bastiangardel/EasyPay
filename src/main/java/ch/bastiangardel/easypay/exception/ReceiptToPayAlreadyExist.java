package ch.bastiangardel.easypay.exception;

/**
 * Created by bastiangardel on 28.06.16.
 */
public class ReceiptToPayAlreadyExist extends RuntimeException {
    public ReceiptToPayAlreadyExist(String message){
        super(message);
    }
}
