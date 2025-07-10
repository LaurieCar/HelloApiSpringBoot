package com.adrar.api.exception.user;

public class EmailAlreadyUseException extends RuntimeException {
    public EmailAlreadyUseException(String message) {
        super(message);
    }
}
