package com.example.cine_magic.services;

import com.example.cine_magic.models.Funcion;
import com.example.cine_magic.repositories.FuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionService implements FuncionServiceI {
    @Autowired
    private FuncionRepository funcionRepository;

    @Override
    public List<Funcion> obtenerFuncion() {
        return funcionRepository.findAll();
    }

    @Override
    public Funcion obtenerFuncionPorId(Long id) {
        return funcionRepository.findById(id).orElse(null);
    }

    @Override
    public Funcion crearFuncion(Funcion funcion) {
        return funcionRepository.save(funcion);
    }

    @Override
    public Funcion actualizarFuncion(Long id, Funcion funcion) {
        return funcionRepository.save(funcion);
    }

    @Override
    public Funcion eliminarFuncion(Long id) { funcionRepository.deleteById(id);
    return null; }
}
