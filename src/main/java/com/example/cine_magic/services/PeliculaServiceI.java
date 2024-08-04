package com.example.cine_magic.services;

import com.example.cine_magic.models.Pelicula;

import java.util.List;

public interface PeliculaServiceI {

    List<Pelicula> obtenerPelicula();
    Pelicula obtenerPeliculaPorId(Long id);
    Pelicula crearPelicula(Pelicula pelicula);
    Pelicula actualizarPelicula(Long id, Pelicula pelicula);
    Pelicula eliminarPelicula(Long id);
}
