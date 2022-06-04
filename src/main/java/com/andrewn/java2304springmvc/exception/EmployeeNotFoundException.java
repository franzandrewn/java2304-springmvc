package com.andrewn.java2304springmvc.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("No employee with id: " + id);
    }
}
