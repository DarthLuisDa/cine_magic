package com.example.cine_magic.exceptions;

import org.springframework.http.HttpStatus;

//@ResponseStatus(HttpSatus.Not_Found)
public class NotFoundException extends RuntimeException{

    private String codigo;
    private HttpStatus estatus;

    public NotFoundException(String mensaje, String codigo, HttpStatus estatus) {
        super(mensaje);
        this.codigo = codigo;
        this.estatus = estatus;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public HttpStatus getEstatus() {
        return estatus;
    }

    public void setEstatus(HttpStatus estatus) {
        this.estatus = estatus;
    }
}
