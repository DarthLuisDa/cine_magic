package com.example.cine_magic.services;

import com.example.cine_magic.models.Calificacion;

import java.util.List;

public interface CalificacionServiceI {

    List<Calificacion> obtenerCalificacion();
    Calificacion obtenerCalificacionPorId(Long id);
    Calificacion crearCalificacion(Calificacion calificacion);
    Calificacion actualizarCalificacion(Long id, Calificacion calificacion);
    Calificacion eliminarCalificacion(Long id);
}
