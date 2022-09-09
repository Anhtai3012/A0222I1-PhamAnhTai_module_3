package com.example.product.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BindException.class})
    public String handleBindException(BindException e) {
        String errorMsg = "BAD REQUEST";
        if (e.getBindingResult().hasErrors()) {
            errorMsg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        }
        return errorMsg;
    }
}
