package com.example.cine_magic.services;

import com.example.cine_magic.models.Pelicula;
import com.example.cine_magic.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService implements PeliculaServiceI {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> obtenerPelicula() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula obtenerPeliculaPorId(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula actualizarPelicula(Long id, Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula eliminarPelicula(Long id) { peliculaRepository.deleteById(id);
        return null; }
}
