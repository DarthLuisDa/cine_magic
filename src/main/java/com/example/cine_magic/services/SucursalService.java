package com.example.cine_magic.services;


import com.example.cine_magic.models.Sucursal;
import com.example.cine_magic.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements SucursalServiceI {
    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<Sucursal> obtenerSucursal() {
        return sucursalRepository.findAll();
    }

    @Override
    public Sucursal obtenerSucursalPorId(Long id) {
        return sucursalRepository.findById(id).orElse(null);
    }

    @Override
    public Sucursal crearSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal actualizarSucursal(Long id, Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal eliminarSucursal(Long id) { sucursalRepository.deleteById(id);
        return null; }
}
