package com.github.pires.example.exception;

/**
 * Created by bastiangardel on 19.05.16.
 */
public class CheckOutNotFoundException extends RuntimeException {

    public CheckOutNotFoundException(String message){
        super(message);
    }
}
