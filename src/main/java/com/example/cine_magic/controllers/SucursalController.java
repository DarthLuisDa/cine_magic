package com.example.cine_magic.controllers;

import com.example.cine_magic.exceptions.IdNotValueException;
import com.example.cine_magic.exceptions.InvalidDataException;
import com.example.cine_magic.exceptions.NotFoundException;
import com.example.cine_magic.models.Sucursal;
import com.example.cine_magic.services.SucursalServiceI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cine_magic_db")
public class SucursalController {
    @Autowired
    SucursalServiceI sucursalService;

    //Sí Funciona al 100%, es el normal
    @GetMapping("/sucursal")
    public List<Sucursal> obtenerSucursal() {return sucursalService.obtenerSucursal();
    }

    //Sí Funciona al 100%
    @GetMapping("/sucursal/{id}")
    public Sucursal obtenerSucursalPorId(@PathVariable Long id) {
        Sucursal sucursal;
        if(id < 1){
            throw new IdNotValueException("El id-sucursal debe ser númerico y mayor  a 0", "err-14", HttpStatus.BAD_REQUEST);
        }
        sucursal = sucursalService.obtenerSucursalPorId(id);
        if(sucursal == null){
            throw new NotFoundException("No se encontró ninguna sucursal con id:"+" "+ id,"err-12",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(sucursal).getBody();
    }


    //Sí Funciona al 100%
    @PostMapping("/sucursal")
    public Sucursal crearSucursal(@Valid @RequestBody Sucursal sucursal, BindingResult resultado) {
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-13",HttpStatus.NOT_FOUND, resultado);
        }
        return sucursalService.crearSucursal(sucursal);
    }


    //Sí Funciona al 100%

    @PutMapping("/sucursal/{id}")
    public Sucursal actualizarSucursal(@PathVariable Long id, @Valid  @RequestBody Sucursal sucursalModificada, BindingResult resultado) {
        Sucursal sucursal;
        if(id < 1){
            throw new IdNotValueException("El id-sucursal debe ser númerico y mayor  a 0", "err-14",HttpStatus.BAD_REQUEST);
        }
        sucursal = sucursalService.obtenerSucursalPorId(id);
        if(sucursal == null){
            throw new NotFoundException("No se encontró ninguna sucursal con ese id:"+" "+ id,"err-12",HttpStatus.NOT_FOUND);
        }
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-13",HttpStatus.BAD_REQUEST, resultado);
        }
        sucursal = sucursalService.actualizarSucursal(id, sucursalModificada);
        return sucursal;
    }

    //Sí Funciona al 100%
    @DeleteMapping("/sucursal/{id}")
    public ResponseEntity<String> eliminarSucursal(@PathVariable Long id){
        Sucursal sucursal;
        if(id < 1){
            throw new IdNotValueException("El id-sucursal debe ser númerico y mayor a 0", "err-14",HttpStatus.BAD_REQUEST);
        }
        sucursal = sucursalService.obtenerSucursalPorId(id);
        if(sucursal == null){
            throw new NotFoundException("No se encontró ninguna sucursal con ese id:"+" "+ id,"err-12",HttpStatus.NOT_FOUND);
        }
        sucursal = sucursalService.eliminarSucursal(id);
        return ResponseEntity.ok("Se eliminó la sucursal con id:"+" "+ id);
    }
}
