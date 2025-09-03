package com.aireya.aireya.exception;

/**
 * Se lanza cuando no existe el recurso solicitado.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
