package com.example.cine_magic.services;

import com.example.cine_magic.models.Asiento;

import java.util.List;

public interface AsientoServiceI {

    List<Asiento> obtenerAsiento();
    Asiento obtenerAsientoPorId(Long id);
    Asiento crearAsiento(Asiento asiento);
    Asiento actualizarAsiento(Long id, Asiento asiento);
    Asiento eliminarAsiento(Long id);
}
