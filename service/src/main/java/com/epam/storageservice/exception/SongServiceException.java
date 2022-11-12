package com.epam.storageservice.exception;


public class SongServiceException extends RuntimeException {
    public SongServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
