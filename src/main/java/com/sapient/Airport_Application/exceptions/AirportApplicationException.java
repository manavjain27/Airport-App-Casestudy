package com.sapient.Airport_Application.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class AirportApplicationException extends RuntimeException {

    String message;
    HttpStatus status;

    public AirportApplicationException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
