package com.newplans.api.exception;

public class RequestValidationException extends Exception {
    public RequestValidationException(String message) {
        super("Request validation: " +message);
    }
}
