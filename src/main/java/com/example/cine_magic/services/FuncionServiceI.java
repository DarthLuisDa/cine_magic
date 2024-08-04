package com.example.cine_magic.services;

import com.example.cine_magic.models.Funcion;

import java.util.List;

public interface FuncionServiceI {

    List<Funcion> obtenerFuncion();
    Funcion obtenerFuncionPorId(Long id);
    Funcion crearFuncion(Funcion funcion);
    Funcion actualizarFuncion(Long id, Funcion funcion);
    Funcion eliminarFuncion(Long id);
}
