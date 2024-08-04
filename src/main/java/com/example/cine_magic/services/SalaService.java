package com.example.cine_magic.services;

import com.example.cine_magic.models.Sala;
import com.example.cine_magic.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService implements SalaServiceI {
    @Autowired
    private SalaRepository salaRepository;

    @Override
    public List<Sala> obtenerSala() {
        return salaRepository.findAll();
    }

    @Override
    public Sala obtenerSalaPorId(Long id) {
        return salaRepository.findById(id).orElse(null);
    }

    @Override
    public Sala crearSala(Sala sala) {
        return salaRepository.save(sala);
    }

    @Override
    public Sala actualizarSala(Long id, Sala sala) {
        return salaRepository.save(sala);
    }

    @Override
    public Sala eliminarSala(Long id) { salaRepository.deleteById(id);
        return null; }
}