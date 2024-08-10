package com.example.cine_magic;

import com.example.cine_magic.models.Funcion;

import com.example.cine_magic.models.Pelicula;
import com.example.cine_magic.repositories.FuncionRepository;
import com.example.cine_magic.services.FuncionService;
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
import static org.mockito.Mockito.when;

public class FuncionServiceTest {
    @Mock
    private FuncionRepository funcionRepository;

    @InjectMocks
    private FuncionService funcionService;

    Funcion funcion;
    private Pelicula FK_ID_Película;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        funcion = new Funcion();
        funcion.setID_Función(String.valueOf(1L));
        funcion.getFK_ID_Película();
    }
    //Búsqueda completa de la lista
    @Test
    void testGetFuncion(){
        when(funcionRepository.findAll()).thenReturn(List.of(funcion,funcion));
        List<Funcion> listaFuncionActual = funcionService.obtenerFuncion();
        assertEquals(2,listaFuncionActual.size());
    }
    //Búsqueda por Id
    @Test
    void testGetFuncionById(){
        when(funcionRepository.findById(1L)).thenReturn(Optional.ofNullable(funcion));
        Funcion funcionActual = funcionService.obtenerFuncionPorId(1L);
        assertEquals(funcion,funcionActual);
    }
    //Registro exitoso de una Funcion
    @Test
    void testCreateFuncion(){
        when(funcionRepository.save(funcion)).thenReturn(funcion);
        Funcion funcionActual = funcionService.crearFuncion(funcion);
        assertEquals(funcion,funcionActual);
    }
    /*
    //Actualización de una Funcion
    @Test
    void testModifyFuncion(){
        when(funcionRepository.save(funcion)).thenReturn(funcion);
        when(funcionRepository.findById(1L)).thenReturn(Optional.ofNullable(funcion));
        funcion.setFK_ID_Película(Pelicula  FK_ID_Película);
        Funcion funcionActualModificada = funcionService.actualizarFuncion(1L, funcion);
        assertEquals("1",funcionActualModificada.getFK_ID_Película("1"));
    }
    */

    //Funcion modificada no encontrada
    @Test
    void testModifyFuncion_whenFuncionNotFound(){
        when(funcionRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Funcion funcionActualModificada = funcionService.actualizarFuncion(1L, funcion);
        assertNull(funcionActualModificada);
    }
    //Eliminación de una Funcion
    @Test
    void testDeleteFuncion(){
        willDoNothing().given(funcionRepository).deleteById(1L);
        funcionService.eliminarFuncion(1L);
        verify(funcionRepository, times(1)).deleteById(1L);
    }

    //Funcion eliminada no encontrada
    @Test
    void testDeleteFuncion_whenFuncionNotFound(){
        when(funcionRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Funcion funcionActualEliminada = funcionService.eliminarFuncion(1L);
        assertNull(funcionActualEliminada);
    }
}
