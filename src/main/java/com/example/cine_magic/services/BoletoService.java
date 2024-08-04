package com.example.cine_magic.services;

import com.example.cine_magic.models.Boleto;
import com.example.cine_magic.repositories.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletoService implements BoletoServiceI {
    @Autowired
    private BoletoRepository boletoRepository;

    @Override
    public List<Boleto> obtenerBoleto() {
        return boletoRepository.findAll();
    }

    @Override
    public Boleto obtenerBoletoPorId(Long id) {
        return boletoRepository.findById(id).orElse(null);
    }

    @Override
    public Boleto crearBoleto(Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    @Override
    public Boleto actualizarBoleto(Long id, Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    @Override
    public Boleto eliminarBoleto(Long id) { boletoRepository.deleteById(id);
        return null; }
}
