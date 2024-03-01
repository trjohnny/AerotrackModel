package com.aerotrack.model.exceptions;

public class DirectionNotAvailableException extends ApiRequestException {
    public DirectionNotAvailableException(String message) {
        super(message);
    }

    public DirectionNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
