package ch.bastiangardel.easypay.exception;

/**
 * Created by bastiangardel on 19.05.16.
 */
public class NoReceiptToPayExeption extends RuntimeException {
    public NoReceiptToPayExeption(String message){
        super(message);
    }
}
