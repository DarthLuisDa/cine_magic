package com.example.cine_magic.services;

import com.example.cine_magic.models.Asiento;
import com.example.cine_magic.repositories.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoService implements AsientoServiceI {
    @Autowired
    private AsientoRepository asientoRepository;

    @Override
    public List<Asiento> obtenerAsiento() {
        return asientoRepository.findAll();
    }

    @Override
    public Asiento obtenerAsientoPorId(Long id) {
        return asientoRepository.findById(id).orElse(null);
    }

    @Override
    public Asiento crearAsiento(Asiento asiento) {
        return asientoRepository.save(asiento);
    }

    @Override
    public Asiento actualizarAsiento(Long id, Asiento asiento) {
        return asientoRepository.save(asiento);
    }

    @Override
    public Asiento eliminarAsiento(Long id) { asientoRepository.deleteById(id);
        return null; }
}
