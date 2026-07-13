package com.example.employeemanagement.advices;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ApiResponse <T> {

    private LocalDateTime timestamp = LocalDateTime.now();
    private T data;
    private ApiError error;

    public ApiResponse() {
    }

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
