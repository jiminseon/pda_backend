package com.example.record.product.utils;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private final boolean success;
    private final T response;
    private final String errorMessage;

    public ApiResponse(boolean success, T response, String errorMessage) {
        this.success = success;
        this.response = response;
        this.errorMessage = errorMessage;
    }

    public static <T> ApiResponse<T> success(T response) {
        return new ApiResponse<>(true, response, null);
    }

    public static <T> ApiResponse<T> failure(String errorMessage) {
        return new ApiResponse<>(false, null, errorMessage);
    }
}
