package com.example.record.product.exception;


public class NoSuchProductException extends CustomException {
    public NoSuchProductException (String errorMessage) {
        super(errorMessage);
    }
}
