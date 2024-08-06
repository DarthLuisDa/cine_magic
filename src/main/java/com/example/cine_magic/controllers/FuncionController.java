package com.example.cine_magic.controllers;

import com.example.cine_magic.exceptions.NotFoundException;
import com.example.cine_magic.exceptions.InvalidDataException;
import com.example.cine_magic.exceptions.IdNotValueException;
import com.example.cine_magic.models.Funcion;
import com.example.cine_magic.services.FuncionServiceI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cine_magic_db")
public class FuncionController {
    @Autowired
    FuncionServiceI funcionService;

    //Sí Funciona al 100%, es el normal
    @GetMapping("/funcion")
    public List<Funcion> obtenerFuncion() {return funcionService.obtenerFuncion();
    }

    //Sí Funciona al 100%
    @GetMapping("/funcion/{id}")
    public Funcion obtenerFuncionPorId(@PathVariable Long id) {
        Funcion funcion;
        if(id < 1){
            throw new IdNotValueException("El id-función debe ser númerico y mayor a 0", "err-16", HttpStatus.BAD_REQUEST);
        }
        funcion = funcionService.obtenerFuncionPorId(id);
        if(funcion == null){
            throw new NotFoundException("No se encontró ninguna función con id:"+" "+ id,"err-17",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(funcion).getBody();
    }


    //Sí Funciona al 100%
    @PostMapping("/funcion")
    public ResponseEntity<String> crearFuncion(@Valid @RequestBody Funcion funcion, BindingResult resultado) {
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-18",HttpStatus.NOT_FOUND, resultado);
        }
        funcion = funcionService.crearFuncion(funcion);
        return ResponseEntity.ok("Se creó:"+ funcion);
    }


   //Sí Funciona al 100%

    @PutMapping("/funcion/{id}")
    public ResponseEntity<String> actualizarFuncion(@PathVariable Long id, @Valid  @RequestBody Funcion funcionModificada, BindingResult resultado) {
        Funcion funcion;
        if(id < 1){
            throw new IdNotValueException("El id-función debe ser númerico y mayor a 0", "err-16",HttpStatus.BAD_REQUEST);
        }
        funcion = funcionService.obtenerFuncionPorId(id);
        if(funcion == null){
            throw new NotFoundException("No se encontró ninguna función con ese id:"+" "+ id,"err-17",HttpStatus.NOT_FOUND);
        }
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-18",HttpStatus.BAD_REQUEST, resultado);
        }
        funcion = funcionService.actualizarFuncion(id, funcionModificada);
        return ResponseEntity.ok("Se modificó la función con id:"+" "+ id);
    }

    //Sí Funciona al 100%
    @DeleteMapping("/funcion/{id}")
    public ResponseEntity<String> eliminarFuncion(@PathVariable Long id){
        Funcion funcion;
        if(id < 1){
            throw new IdNotValueException("El id-función debe ser númerico y mayor a 0", "err-16",HttpStatus.BAD_REQUEST);
        }
        funcion = funcionService.obtenerFuncionPorId(id);
        if(funcion == null){
            throw new NotFoundException("No se encontró ninguna función con ese id:"+" "+ id,"err-17",HttpStatus.NOT_FOUND);
        }
        funcion = funcionService.eliminarFuncion(id);
        return ResponseEntity.ok("Se eliminó la función con id:"+" "+ id);
    }
}