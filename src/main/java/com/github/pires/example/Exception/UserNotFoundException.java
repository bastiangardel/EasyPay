package com.github.pires.example.exception;

/**
 * Created by bastiangardel on 19.05.16.
 */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
