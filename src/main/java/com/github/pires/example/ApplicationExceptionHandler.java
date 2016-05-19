package com.github.pires.example;

import com.github.pires.example.Exception.CheckOutNotFoundException;
import com.github.pires.example.Exception.ReceiptAlreadyPayExeption;
import com.github.pires.example.Exception.UserNotFoundException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

/**
 * TODO add description
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(
            {AuthenticationException.class, UnknownAccountException.class,
                    UnauthenticatedException.class, IncorrectCredentialsException.class, UnauthorizedException.class})
    public void unauthorized() {
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(
            {EntityNotFoundException.class})
    public void ressourceNotFound() {
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This CheckOut is not found in the system!")
    @ExceptionHandler(
            {CheckOutNotFoundException.class})
    public void checkoutNotFound() {
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This User is not found in the system!")
    @ExceptionHandler(
            {UserNotFoundException.class})
    public void userNotFound() {
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The receipt is already pay!")
    @ExceptionHandler(
            {ReceiptAlreadyPayExeption.class})
    public void receiptAlreadyPay() {
    }
}
