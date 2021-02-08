package com.erickfranco.cv_api.configurations.exceptionconfig.exception;

public class NotFoundExcepton extends RuntimeException {
    public NotFoundExcepton() {

    }

    public NotFoundExcepton(String message) {
        super(message);
    }
}
