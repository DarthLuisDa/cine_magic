package com.example.cine_magic.services;

import com.example.cine_magic.models.Espectador;

import java.util.List;

public interface EspectadorServiceI {

    List<Espectador> obtenerEspectador();
    Espectador obtenerEspectadorPorId(Long id);
    Espectador crearEspectador(Espectador espectador);
    Espectador actualizarEspectador(Long id, Espectador espectador);
    Espectador eliminarEspectador(Long id);
}
