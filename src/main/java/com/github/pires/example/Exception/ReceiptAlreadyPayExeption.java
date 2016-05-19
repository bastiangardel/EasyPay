package com.github.pires.example.Exception;

/**
 * Created by bastiangardel on 19.05.16.
 */
public class ReceiptAlreadyPayExeption extends RuntimeException {
    public ReceiptAlreadyPayExeption(String message){
        super(message);
    }
}
