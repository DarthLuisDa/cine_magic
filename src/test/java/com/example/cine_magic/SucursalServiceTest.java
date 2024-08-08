package com.example.cine_magic;

import com.example.cine_magic.models.Sucursal;
import com.example.cine_magic.repositories.SucursalRepository;
import com.example.cine_magic.services.SucursalService;
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

public class SucursalServiceTest {
    @Mock
    private SucursalRepository sucursalRepository;

    @InjectMocks
    private SucursalService sucursalService;

    Sucursal sucursal;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        sucursal = new Sucursal();
        sucursal.setID_Sucursal(String.valueOf(1L));
        sucursal.getNombre_Sucursal("Torres Landa");
    }
    //Búsqueda completa de la lista
    @Test
    void testGetSucursal(){
        when(sucursalRepository.findAll()).thenReturn(List.of(sucursal,sucursal));
        List<Sucursal> listaSucursalActual = sucursalService.obtenerSucursal();
        assertEquals(2,listaSucursalActual.size());
    }
    //Búsqueda por Id
    @Test
    void testGetSucursalById(){
        when(sucursalRepository.findById(1L)).thenReturn(Optional.ofNullable(sucursal));
        Sucursal sucursalActual = sucursalService.obtenerSucursalPorId(1L);
        assertEquals(sucursal,sucursalActual);
    }
    //Registro exitoso de una Sucursal
    @Test
    void testCreateSucursal(){
        when(sucursalRepository.save(sucursal)).thenReturn(sucursal);
        Sucursal sucursalActual = sucursalService.crearSucursal(sucursal);
        assertEquals(sucursal,sucursalActual);
    }
    //Actualización de una Sucursal
    @Test
    void testModifySucursal(){
        when(sucursalRepository.save(sucursal)).thenReturn(sucursal);
        when(sucursalRepository.findById(1L)).thenReturn(Optional.ofNullable(sucursal));
        sucursal.setNombre_Sucursal("Torres Landa");
        Sucursal sucursalActualModificada = sucursalService.actualizarSucursal(1L, sucursal);
        assertEquals("Torres Landa",sucursalActualModificada.getNombre_Sucursal("Torres Landa"));
    }
    //Sucursal modificada no encontrada
    @Test
    void testModifySucursal_whenSucursalNotFound(){
        when(sucursalRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Sucursal sucursalActualModificada = sucursalService.actualizarSucursal(1L, sucursal);
        assertNull(sucursalActualModificada);
    }
    //Eliminación de una Sucursal
    @Test
    void testDeleteSucursal(){
        willDoNothing().given(sucursalRepository).deleteById(1L);
        sucursalService.eliminarSucursal(1L);
        verify(sucursalRepository, times(1)).deleteById(1L);
    }

    //Sucursal eliminada no encontrada
    @Test
    void testDeleteSucursal_whenSucursalNotFound(){
        when(sucursalRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Sucursal sucursalActualEliminada = sucursalService.eliminarSucursal(1L);
        assertNull(sucursalActualEliminada);
    }
}
