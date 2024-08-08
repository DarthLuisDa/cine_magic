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
import java.util.Optional;

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
    void testGetPelicula(){
        when(peliculaRepository.findAll()).thenReturn(List.of(pelicula,pelicula));
        List<Pelicula> listaPeliculaActual = peliculaService.obtenerPelicula();
        assertEquals(2,listaPeliculaActual.size());
    }
    //Búsqueda por Id
    @Test
    void testGetPeliculaById(){
        when(peliculaRepository.findById(1L)).thenReturn(Optional.ofNullable(pelicula));
        Pelicula peliculaActual = peliculaService.obtenerPeliculaPorId(1L);
        assertEquals(pelicula,peliculaActual);
    }
    //Registro exitoso de una Pelicula
    @Test
    void testCreatePelicula(){
        when(peliculaRepository.save(pelicula)).thenReturn(pelicula);
        Pelicula peliculaActual = peliculaService.crearPelicula(pelicula);
        assertEquals(pelicula,peliculaActual);
    }
    //Actualización de una Pelicula
    @Test
    void testModifyPelicula(){
        when(peliculaRepository.save(pelicula)).thenReturn(pelicula);
        when(peliculaRepository.findById(1L)).thenReturn(Optional.ofNullable(pelicula));
        pelicula.setTítulo("Intensamente 2");
        Pelicula peliculaActualModificada = peliculaService.actualizarPelicula(1L, pelicula);
        assertEquals("Intensamente 2",peliculaActualModificada.getTítulo("Intensamente 2"));
    }
    //Pelicula modificada no encontrada
    @Test
    void testModifyPelicula_whenPeliculaNotFound(){
        when(peliculaRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Pelicula peliculaActualModificada = peliculaService.actualizarPelicula(1L, pelicula);
        assertNull(peliculaActualModificada);
    }
    //Eliminación de una Pelicula
    @Test
    void testDeletePelicula(){
        willDoNothing().given(peliculaRepository).deleteById(1L);
        peliculaService.eliminarPelicula(1L);
        verify(peliculaRepository, times(1)).deleteById(1L);
    }

    //Pelicula eliminada no encontrada
    @Test
    void testDeletePelicula_whenPeliculaNotFound(){
        when(peliculaRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Pelicula peliculaActualEliminada = peliculaService.eliminarPelicula(1L);
        assertNull(peliculaActualEliminada);
    }
}
