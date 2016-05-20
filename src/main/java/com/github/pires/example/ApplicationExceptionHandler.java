package com.github.pires.example;

import com.github.pires.example.Exception.*;
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

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Login Fail!")
    @ExceptionHandler(
            {AuthenticationException.class})
    public void unauthorized1() {
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "This account is not in the system!")
    @ExceptionHandler(
            {UnknownAccountException.class})
    public void unauthorized2() {
    }


    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "You are not authenticated!")
    @ExceptionHandler(
            {UnauthenticatedException.class})
    public void unauthorized3() {
    }


    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "The credentials are incorrect!")
    @ExceptionHandler(
            {IncorrectCredentialsException.class})
    public void unauthorized4() {
    }


    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "You are not authorize to access this resource!")
    @ExceptionHandler(
            {UnauthorizedException.class})
    public void unauthorized5() {
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

    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "The UUID is already in use!")
    @ExceptionHandler(
            {UUIDAlreadyInUseException.class})
    public void uuidAlreadyInUse() {
    }

    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "You don't have enough money on your account!")
    @ExceptionHandler(
            {NotEnoughMoneyException.class})
    public void notEnoughMoney() {
    }
}
