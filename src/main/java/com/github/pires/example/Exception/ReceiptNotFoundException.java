package com.github.pires.example.exception;

/**
 * Created by bastiangardel on 19.05.16.
 */
public class ReceiptNotFoundException extends RuntimeException {
    public ReceiptNotFoundException(String message){
        super(message);
    }
}
