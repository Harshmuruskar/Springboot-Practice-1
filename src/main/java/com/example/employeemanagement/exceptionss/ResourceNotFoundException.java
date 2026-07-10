package com.example.employeemanagement.exceptionss;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException (String message){
        super(message);

    }
}
