package ch.bastiangardel.easypay.exception;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException(String message){
        super(message);
    }
}
