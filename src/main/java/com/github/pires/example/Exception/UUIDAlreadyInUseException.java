package com.github.pires.example.Exception;

/**
 * Created by bastiangardel on 20.05.16.
 */
public class UUIDAlreadyInUseException extends RuntimeException {
    public UUIDAlreadyInUseException(String message){
        super(message);
    }
}
