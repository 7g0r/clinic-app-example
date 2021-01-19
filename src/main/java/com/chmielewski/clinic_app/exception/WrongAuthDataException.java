package com.chmielewski.clinic_app.exception;

public class WrongAuthDataException extends RuntimeException{
    public WrongAuthDataException() {
        super("Incorect ID or PIN");
    }
}
