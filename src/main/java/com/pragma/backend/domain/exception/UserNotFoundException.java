package com.pragma.backend.domain.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("No se encontró un usuario con id " + id);
    }
}
