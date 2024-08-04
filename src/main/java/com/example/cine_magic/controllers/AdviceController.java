package com.example.cine_magic.controllers;

import com.example.cine_magic.exceptions.*;
import com.example.cine_magic.utils.ModelError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdviceController {

    private static  final Logger LOG = LoggerFactory.getLogger(AdviceController.class.getName());

    @ExceptionHandler(value = InvalidDataException.class)
    public ResponseEntity<ModelError> excepcionSolicitud(InvalidDataException excepcion){
        List<String> errores = excepcion.getResultado().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        LOG.debug(excepcion.getMessage(), excepcion);
        ModelError modelError = new ModelError(new SimpleDateFormat("dd-MM-yyyy").format(new Date()),excepcion.getCodigo(), excepcion.getMessage(),errores);
        return new ResponseEntity<>(modelError, excepcion.getEstatus());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ModelError> excepcionElementoNoEncontrado(NotFoundException excepcion){
        ModelError modelError = new ModelError(new SimpleDateFormat("dd-MM-yyyy").format(new Date()),excepcion.getCodigo(), excepcion.getMessage());
        return new ResponseEntity<>(modelError, excepcion.getEstatus());
    }

    @ExceptionHandler(value = IdNotValueException.class)
    public ResponseEntity<ModelError> excepcionBusquedaPorId(IdNotValueException excepcion){
        ModelError modelError = new ModelError(new SimpleDateFormat("dd-MM-yyyy").format(new Date()),excepcion.getCodigo(), excepcion.getMessage());
        return new ResponseEntity<>(modelError, excepcion.getEstatus());
    }

}
