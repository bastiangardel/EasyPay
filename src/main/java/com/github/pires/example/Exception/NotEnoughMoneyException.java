package com.github.pires.example.Exception;

/**
 * Created by bastiangardel on 20.05.16.
 */
public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message){
        super(message);
    }
}
