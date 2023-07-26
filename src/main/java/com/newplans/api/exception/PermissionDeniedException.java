package com.newplans.api.exception;

public class PermissionDeniedException extends Exception {
    public PermissionDeniedException(String message) {
        super("Permission denied: " + message);
    }
}
