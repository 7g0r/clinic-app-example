package com.chmielewski.clinic_app.exception;

public class WrongIdException extends RuntimeException {
    public WrongIdException() {
        super("Wrong id!");
    }

    public WrongIdException(Long id) {
        super("Wrong id=" + id + ".");
    }
}