package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;

public class PlantException extends RuntimeException {

    private final HttpStatus httpStatus;

    public PlantException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
