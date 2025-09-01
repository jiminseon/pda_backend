package com.example.record.utils;

public class ApiResponse<T> {
    private final boolean success;
    private final T response;
    private final String errorMessage;

    public ApiResponse(boolean success, T response, String errorMessage) {
        this.success = success;
        this.response = response;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public T getResponse() {
        return response;
    }

}
