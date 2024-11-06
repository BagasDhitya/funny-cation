package com.example.funnycation.dto;

public class ApiResponse<T> {
    private T data;
    private String message;
    private int status;

    public ApiResponse(T data, int status) {
        this.data = data;
        this.status = status;
    }

    public ApiResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}