package com.prodact.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class customResponseEntityException extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<?> handleWalletException(walletException ex, WebRequest request){
    	walletExceptionResponce response = new walletExceptionResponce(ex.getMessage());
        return new ResponseEntity<walletExceptionResponce>(response, HttpStatus.BAD_REQUEST);
    }
}
