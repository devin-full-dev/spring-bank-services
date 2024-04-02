package com.devindev.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerExistException extends RuntimeException{
    public CustomerExistException(String message){
        super(message);
    }
}
