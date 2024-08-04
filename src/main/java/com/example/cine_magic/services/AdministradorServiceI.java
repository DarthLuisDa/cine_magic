package com.example.cine_magic.services;

import com.example.cine_magic.models.Administrador;

import java.util.List;

public interface AdministradorServiceI {

    List<Administrador> obtenerAdministrador();
    Administrador obtenerAdministradorPorId(Long id);
    Administrador crearAdministrador(Administrador administrador);
    Administrador actualizarAdministrador(Long id, Administrador administrador);
    Administrador eliminarAdministrador(Long id);
}
