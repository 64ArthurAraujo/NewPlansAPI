package com.newplans.api.exception;

public class NoSuchEntryException extends Exception {
    public NoSuchEntryException(String message) {
        super("No such entry: " + message);
    }
}
