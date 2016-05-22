package com.github.pires.example.exception;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException(String message){
        super(message);
    }
}
