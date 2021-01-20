package com.chmielewski.clinic_app.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundHandler(NotFoundException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(WrongAuthDataException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String wrongAuthDataExceptionHandler(WrongAuthDataException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DoctorBusyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String doctorBusyExceptionHandler(DoctorBusyException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(WrongIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String wrongIdExceptionHandler(WrongIdException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String entityNotFoundExceptionHandler(EntityNotFoundException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String validationExceptionHandler(MethodArgumentNotValidException e) {
        return e.getLocalizedMessage();
    }

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String dataIntegrityViolationException(DataIntegrityViolationException e) {
        return e.getMostSpecificCause().getMessage();
    }

    @ResponseBody
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String invalidDataAccessApiUsageExceptionHandler(InvalidDataAccessApiUsageException e) {
        return e.getMostSpecificCause().getMessage();
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e) {
        return e.getMostSpecificCause().getMessage();
    }
}
