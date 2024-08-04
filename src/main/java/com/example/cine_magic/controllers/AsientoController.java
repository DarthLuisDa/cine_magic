package com.example.cine_magic.controllers;

import com.example.cine_magic.exceptions.IdNotValueException;
import com.example.cine_magic.exceptions.InvalidDataException;
import com.example.cine_magic.exceptions.NotFoundException;
import com.example.cine_magic.models.Asiento;
import com.example.cine_magic.services.AsientoServiceI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cine_magic_db")
public class AsientoController {
    @Autowired
    AsientoServiceI asientoService;

    //Sí Funciona al 100%, es el normal
    @GetMapping("/asiento")
    public List<Asiento> obtenerAsiento() {return asientoService.obtenerAsiento();
    }

    //Sí Funciona al 100%
    @GetMapping("/asiento/{id}")
    public Asiento obtenerAsientoPorId(@PathVariable Long id) {
        Asiento asiento;
        if(id < 1){
            throw new IdNotValueException("El asiento debe ser númerico y mayor a 0", "err-72", HttpStatus.BAD_REQUEST);
        }
        asiento = asientoService.obtenerAsientoPorId(id);
        if(asiento == null){
            throw new NotFoundException("No se encontró ningún asiento con id:"+" "+ id,"err-73",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(asiento).getBody();
    }


    //Sí Funciona al 100%
    @PostMapping("/asiento")
    public Asiento crearAsiento(@Valid @RequestBody Asiento asiento, BindingResult resultado) {
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-74",HttpStatus.NOT_FOUND, resultado);
        }
        return asientoService.crearAsiento(asiento);
    }


    //Sí Funciona al 100%

    @PutMapping("/asiento/{id}")
    public Asiento actualizarAsiento(@PathVariable Long id, @Valid  @RequestBody Asiento asientoModificado, BindingResult resultado) {
        Asiento asiento;
        if(id < 1){
            throw new IdNotValueException("El asiento debe ser númerico y mayor a 0", "err-72",HttpStatus.BAD_REQUEST);
        }
        asiento = asientoService.obtenerAsientoPorId(id);
        if(asiento == null){
            throw new NotFoundException("No se encontró ningún asiento con ese id:"+" "+ id,"err-73",HttpStatus.NOT_FOUND);
        }
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-74",HttpStatus.BAD_REQUEST, resultado);
        }
        asiento = asientoService.actualizarAsiento(id, asientoModificado);
        return asiento;
    }

    //Sí Funciona al 100%
    @DeleteMapping("/asiento/{id}")
    public ResponseEntity<String> eliminarAsiento(@PathVariable Long id){
        Asiento asiento;
        if(id < 1){
            throw new IdNotValueException("El asiento debe ser númerico y mayor a 0", "err-25",HttpStatus.BAD_REQUEST);
        }
        asiento = asientoService.obtenerAsientoPorId(id);
        if(asiento == null){
            throw new NotFoundException("No se encontró ningún asiento con ese id:"+" "+ id,"err-23",HttpStatus.NOT_FOUND);
        }
        asiento = asientoService.eliminarAsiento(id);
        return ResponseEntity.ok("Se eliminó el asiento con id:"+" "+ id);
    }
}
