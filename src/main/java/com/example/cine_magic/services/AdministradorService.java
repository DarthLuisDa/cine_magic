package com.example.cine_magic.services;

import com.example.cine_magic.models.Administrador;
import com.example.cine_magic.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService implements AdministradorServiceI {
    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public List<Administrador> obtenerAdministrador() {
        return administradorRepository.findAll();
    }

    @Override
    public Administrador obtenerAdministradorPorId(Long id) {
        return administradorRepository.findById(id).orElse(null);
    }

    @Override
    public Administrador crearAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    public Administrador actualizarAdministrador(Long id, Administrador administrador) {return administradorRepository.save(administrador);
    }

    @Override
    public Administrador eliminarAdministrador(Long id) { administradorRepository.deleteById(id);
        return null; }
}