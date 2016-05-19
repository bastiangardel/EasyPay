package com.github.pires.example.Exception;

/**
 * Created by bastiangardel on 19.05.16.
 */
public class CheckOutNotFoundException extends RuntimeException {

    public CheckOutNotFoundException(String message){
        super(message);
    }
}
