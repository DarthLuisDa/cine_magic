package com.example.cine_magic.services;

import com.example.cine_magic.models.Sala;

import java.util.List;

public interface SalaServiceI {

    List<Sala> obtenerSala();
    Sala obtenerSalaPorId(Long id);
    Sala crearSala(Sala sala);
    Sala actualizarSala(Long id, Sala sala);
    Sala eliminarSala(Long id);
}
