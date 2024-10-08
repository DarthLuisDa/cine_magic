package com.example.cine_magic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class InvalidDataException extends RuntimeException {

    private String codigo;
    private HttpStatus estatus;
    private BindingResult resultado;

    public InvalidDataException(String mensaje, String codigo, HttpStatus estatus, BindingResult resultado) {
        super(mensaje);
        this.codigo = codigo;
        this.estatus = estatus;
        this.resultado = resultado;
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

    public BindingResult getResultado() {
        return resultado;
    }

    public void setResultado(BindingResult resultado) {
        this.resultado = resultado;
    }
}
