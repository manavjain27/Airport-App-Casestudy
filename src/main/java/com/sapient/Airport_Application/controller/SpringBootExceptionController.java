package com.sapient.Airport_Application.controller;

import com.sapient.Airport_Application.exceptions.AirportApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SpringBootExceptionController {

    @ExceptionHandler(AirportApplicationException.class)
    public ResponseEntity<String> dataNotFound(AirportApplicationException exception) {
       return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
    }
}
