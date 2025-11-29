package com.example.collegemanager.exceptions;

public class CannotBeEmptyException extends RuntimeException {
    public CannotBeEmptyException(String message) {
        super(message);
    }
}
