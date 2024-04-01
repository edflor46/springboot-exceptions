package com.yahikko.springboot.exceptions.springbootexceptions.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.yahikko.springboot.exceptions.springbootexceptions.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    private static final String ERROR_DIVISION = "Division entre 0";
    private static final String RESOURCE_NOT_FOUND = "Recurso no encontrado";
    private static final Integer STATUS_NOT_FOUND = 404;

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception exception) {

        final Error error = new Error();
        error.setDate(new Date());
        error.setError(ERROR_DIVISION);
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        // return ResponseEntity.internalServerError().body(error);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);

    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception exception) {
        final Map<String, Object> error = new HashMap<>();
        
        error.put("date", new Date().toString());
        error.put("error", "number format invalid");
        error.put("message", exception.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundException(final NoHandlerFoundException exception) {

        Error error = new Error();

        error.setDate(new Date());
        error.setError(RESOURCE_NOT_FOUND);
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(STATUS_NOT_FOUND).body(error);

    }

}
