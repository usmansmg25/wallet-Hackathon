package com.prodact.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class walletException extends RuntimeException{
    public walletException(String message) { super(message);}
}