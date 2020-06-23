package com.mg.backend001.config.exception.exc;

public class EmptyResultDataAccessException extends Exception {

    public EmptyResultDataAccessException(String message) {
        super(message);
    }

    public EmptyResultDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
