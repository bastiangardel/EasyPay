package ch.bastiangardel.easypay.exception;

/**
 * Created by bastiangardel on 05.07.16.
 */
public class NotEnoughMoneyDebitException extends RuntimeException{
    public NotEnoughMoneyDebitException(String message){
        super(message);
    }
}
