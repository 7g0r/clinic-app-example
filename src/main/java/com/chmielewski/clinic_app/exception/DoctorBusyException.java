package com.chmielewski.clinic_app.exception;

public class DoctorBusyException extends RuntimeException {
    public DoctorBusyException() {
    super("Doctor already has a visit scheduled for that time frame");
}
}
