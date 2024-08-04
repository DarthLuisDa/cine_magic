package com.example.cine_magic.services;

import com.example.cine_magic.models.Sucursal;

import java.util.List;

public interface SucursalServiceI {

    List<Sucursal> obtenerSucursal();
    Sucursal obtenerSucursalPorId(Long id);
    Sucursal crearSucursal(Sucursal sucursal);
    Sucursal actualizarSucursal(Long id, Sucursal sucursal);
    Sucursal eliminarSucursal(Long id);
}