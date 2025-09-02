package com.example.record.product.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class NoSuchProductException extends CustomException {
    public NoSuchProductException (String errorMessage) {
        super(errorMessage);
    }
}
