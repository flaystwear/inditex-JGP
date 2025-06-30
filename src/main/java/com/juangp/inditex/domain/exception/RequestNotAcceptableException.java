package com.juangp.inditex.domain.exception;

public class RequestNotAcceptableException extends RuntimeException {
    public RequestNotAcceptableException() {
        super();
    }

    public RequestNotAcceptableException(String message) {
        super(message);
    }

}
