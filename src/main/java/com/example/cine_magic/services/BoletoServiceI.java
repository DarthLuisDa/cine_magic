package com.example.cine_magic.services;

import com.example.cine_magic.models.Boleto;

import java.util.List;

public interface BoletoServiceI {

    List<Boleto> obtenerBoleto();
    Boleto obtenerBoletoPorId(Long id);
    Boleto crearBoleto(Boleto boleto);
    Boleto actualizarBoleto(Long id, Boleto boleto);
    Boleto eliminarBoleto(Long id);
}
