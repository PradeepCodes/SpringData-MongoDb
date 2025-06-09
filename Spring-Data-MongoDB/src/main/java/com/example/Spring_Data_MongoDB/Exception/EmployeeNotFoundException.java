package com.example.Spring_Data_MongoDB.Exception;

public class EmployeeNotFoundException extends RuntimeException  {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
