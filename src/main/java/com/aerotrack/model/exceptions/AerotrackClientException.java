package com.aerotrack.model.exceptions;

public class AerotrackClientException extends RuntimeException {

    public AerotrackClientException(ApiRequestException message) {
        super(message);
    }

    public AerotrackClientException(String message, Throwable cause) {
        super(message, cause);
    }
}