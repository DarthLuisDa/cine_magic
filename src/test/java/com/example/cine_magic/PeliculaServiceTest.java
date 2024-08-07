package com.example.cine_magic;

import com.example.cine_magic.models.Pelicula;
import com.example.cine_magic.repositories.PeliculaRepository;
import com.example.cine_magic.services.PeliculaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

public class PeliculaServiceTest {

    @Mock
    private PeliculaRepository peliculaRepository;

    @InjectMocks
    private PeliculaService peliculaService;

    Pelicula pelicula;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        pelicula = new Pelicula();
        pelicula.setID_Película(String.valueOf(1L));
        pelicula.getTítulo("Intensamente 2");
    }
    //Búsqueda completa de la lista
    @Test
    void testGetTarea(){
        when(peliculaRepository.findAll()).thenReturn(List.of(pelicula,pelicula));
        List<Pelicula> listaTareaActual = peliculaService.obtenerPelicula();
        assertEquals(2,listaTareaActual.size());
    }
}