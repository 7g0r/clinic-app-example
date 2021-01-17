package com.chmielewski.clinic_app.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id, String className) {
        super("Could not find " + className + " with id = " + id + ".");
    }
}