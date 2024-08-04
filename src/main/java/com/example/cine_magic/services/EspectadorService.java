package com.example.cine_magic.services;

import com.example.cine_magic.models.Espectador;
import com.example.cine_magic.repositories.EspectadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspectadorService implements EspectadorServiceI {
    @Autowired
    private EspectadorRepository espectadorRepository;

    @Override
    public List<Espectador> obtenerEspectador() {
        return espectadorRepository.findAll();
    }

    @Override
    public Espectador obtenerEspectadorPorId(Long id) {
        return espectadorRepository.findById(id).orElse(null);
    }

    @Override
    public Espectador crearEspectador(Espectador espectador) {
        return espectadorRepository.save(espectador);
    }

    @Override
    public Espectador actualizarEspectador(Long id, Espectador espectador) {return espectadorRepository.save(espectador);
    }

    @Override
    public Espectador eliminarEspectador(Long id) { espectadorRepository.deleteById(id);
        return null; }
}
