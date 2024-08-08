package com.example.cine_magic;

import com.example.cine_magic.models.Asiento;
import com.example.cine_magic.repositories.AsientoRepository;
import com.example.cine_magic.services.AsientoService;
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

public class AsientoServiceTest {
    @Mock
    private AsientoRepository asientoRepository;

    @InjectMocks
    private AsientoService asientoService;

    Asiento asiento;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        asiento = new Asiento();
        asiento.setID_Asiento(String.valueOf(1L));
        asiento.getFila("A");
    }
    //Búsqueda completa de la lista
    @Test
    void testGetAsiento(){
        when(asientoRepository.findAll()).thenReturn(List.of(asiento,asiento));
        List<Asiento> listaAsientoActual = asientoService.obtenerAsiento();
        assertEquals(2,listaAsientoActual.size());
    }
    //Búsqueda por Id
    @Test
    void testGetAsientoById(){
        when(asientoRepository.findById(1L)).thenReturn(Optional.ofNullable(asiento));
        Asiento asientoActual = asientoService.obtenerAsientoPorId(1L);
        assertEquals(asiento,asientoActual);
    }
    //Registro exitoso de un Asiento
    @Test
    void testCreateAsiento(){
        when(asientoRepository.save(asiento)).thenReturn(asiento);
        Asiento asientoActual = asientoService.crearAsiento(asiento);
        assertEquals(asiento,asientoActual);
    }
    //Actualización de un Asiento
    @Test
    void testModifyAsiento(){
        when(asientoRepository.save(asiento)).thenReturn(asiento);
        when(asientoRepository.findById(1L)).thenReturn(Optional.ofNullable(asiento));
        asiento.setFila("A");
        Asiento asientoActualModificado = asientoService.actualizarAsiento(1L, asiento);
        assertEquals("A",asientoActualModificado.getFila("A"));
    }
    //Asiento modificada no encontrado
    @Test
    void testModifyAsiento_whenAsientoNotFound(){
        when(asientoRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Asiento asientoActualModificada = asientoService.actualizarAsiento(1L, asiento);
        assertNull(asientoActualModificada);
    }
    //Eliminación de un Asiento
    @Test
    void testDeleteAsiento(){
        willDoNothing().given(asientoRepository).deleteById(1L);
        asientoService.eliminarAsiento(1L);
        verify(asientoRepository, times(1)).deleteById(1L);
    }

    //Asiento eliminada no encontrado
    @Test
    void testDeleteAsiento_whenAsientoNotFound(){
        when(asientoRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Asiento asientoActualEliminado = asientoService.eliminarAsiento(1L);
        assertNull(asientoActualEliminado);
    }
}
