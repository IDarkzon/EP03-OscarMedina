package com.dae.ep4.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String id) {
        super(String.format("El usuario %s no existe.", id));
    }
}
