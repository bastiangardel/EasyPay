package com.github.pires.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class EmailAlreadyInUseException extends RuntimeException {

}
