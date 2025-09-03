package com.example.record.product.Exception;

import com.example.record.product.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class MyControllerAdvice {

    @ExceptionHandler(DuplicatedMemberException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public <T> ApiResponse<T> handleDuplicatedMemberException(DuplicatedMemberException e) {
        return ApiResponse.failure(e.getMessage());
    }

    @ExceptionHandler(NoSuchProductException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public <T> ApiResponse<T> handleNoSuchProductException(NoSuchProductException e) {
        return ApiResponse.failure(e.getMessage());
    }
}
