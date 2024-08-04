package com.example.cine_magic.services;

import com.example.cine_magic.models.Calificacion;
import com.example.cine_magic.repositories.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionService implements CalificacionServiceI {
    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public List<Calificacion> obtenerCalificacion() {
        return calificacionRepository.findAll();
    }

    @Override
    public Calificacion obtenerCalificacionPorId(Long id) {
        return calificacionRepository.findById(id).orElse(null);
    }

    @Override
    public Calificacion crearCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion actualizarCalificacion(Long id, Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion eliminarCalificacion(Long id) { calificacionRepository.deleteById(id);
        return null;
    }
}
