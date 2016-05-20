package com.github.pires.example.Exception;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException(String message){
        super(message);
    }
}
