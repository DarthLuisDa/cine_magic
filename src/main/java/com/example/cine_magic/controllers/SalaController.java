package com.example.cine_magic.controllers;

import com.example.cine_magic.exceptions.IdNotValueException;
import com.example.cine_magic.exceptions.InvalidDataException;
import com.example.cine_magic.exceptions.NotFoundException;
import com.example.cine_magic.models.Sala;
import com.example.cine_magic.services.SalaServiceI;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/cine_magic_db")
public class SalaController {
    @Autowired
    SalaServiceI salaService;

    //Sí Funciona al 100%, es el normal
    @GetMapping("/sala")
    public List<Sala> obtenerSala() {return salaService.obtenerSala();
    }

    //Sí Funciona al 100%
    @GetMapping("/sala/{id}")
    public Sala obtenerSalaPorId(@PathVariable Long id) {
        Sala sala;
        if(id < 1){
            throw new IdNotValueException("El id-sala debe ser númerico y mayor a 0", "err-84", HttpStatus.BAD_REQUEST);
        }
        sala = salaService.obtenerSalaPorId(id);
        if(sala == null){
            throw new NotFoundException("No se encontró ninguna sala con id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(sala).getBody();
    }


    //Sí Funciona al 100%
    @PostMapping("/sala")
    public Sala crearSala(@Valid @RequestBody Sala sala, BindingResult resultado) {
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.NOT_FOUND, resultado);
        }
        return salaService.crearSala(sala);
    }


    //Sí Funciona al 100%

    @PutMapping("/sala/{id}")
    public ResponseEntity<String> actualizarSala(@PathVariable Long id, @Valid  @RequestBody Sala salaModificada, BindingResult resultado) {
        Sala sala;
        if(id < 1){
            throw new IdNotValueException("El id-sala debe ser númerico y mayor a 0", "err-84",HttpStatus.BAD_REQUEST);
        }
        sala = salaService.obtenerSalaPorId(id);
        if(sala == null){
            throw new NotFoundException("No se encontró ninguna sala con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.BAD_REQUEST, resultado);
        }
        if(id == 1){
           return ResponseEntity.badRequest().body("No se puede modificar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 2){
            return ResponseEntity.badRequest().body("No se puede modificar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 3){
            return ResponseEntity.badRequest().body("No se puede modificar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 4){
            return ResponseEntity.badRequest().body("No se puede modificar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 5){
            return ResponseEntity.badRequest().body("No se puede modificar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 6){
            return ResponseEntity.badRequest().body("No se puede modificar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 7){
            return ResponseEntity.badRequest().body("No se puede modificar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 8){
            return ResponseEntity.badRequest().body("No se puede modificar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 9){
            return ResponseEntity.badRequest().body("No se puede modificar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 10){
            return ResponseEntity.badRequest().body("No se puede modificar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        sala = salaService.actualizarSala(id, salaModificada);
        return ResponseEntity.ok("Se modificó la sala con id:"+" "+ id);
    }

    //Sí Funciona al 100%
    @DeleteMapping("/sala/{id}")
    public ResponseEntity<String> eliminarSala(@PathVariable Long id){
        Sala sala;
        if(id < 1){
            throw new IdNotValueException("El id-sala debe ser númerico y mayor a 0", "err-84",HttpStatus.BAD_REQUEST);
        }
        sala = salaService.obtenerSalaPorId(id);
        if(sala == null){
            throw new NotFoundException("No se encontró ninguna sala con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        if(id == 1){
            return ResponseEntity.badRequest().body("No se puede eliminar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 2){
            return ResponseEntity.badRequest().body("No se puede eliminar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 3){
            return ResponseEntity.badRequest().body("No se puede eliminar el id-sala:"+" "+ id +" "+"puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 4) {
            return ResponseEntity.badRequest().body("No se puede eliminar el id-sala:" + " " + id + " " + "puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 5) {
            return ResponseEntity.badRequest().body("No se puede eliminar el id-sala:" + " " + id + " " + "puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 6) {
            return ResponseEntity.badRequest().body("No se puede eliminar el id-sala:" + " " + id + " " + "puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 7) {
            return ResponseEntity.badRequest().body("No se puede eliminar el id-sala:" + " " + id + " " + "puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 8) {
            return ResponseEntity.badRequest().body("No se puede eliminar el id-sala:" + " " + id + " " + "puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 9) {
            return ResponseEntity.badRequest().body("No se puede eliminar el id-sala:" + " " + id + " " + "puesto que varias funciones de cine ya lo contienen");
        }
        if(id == 10) {
            return ResponseEntity.badRequest().body("No se puede eliminar el id-sala:" + " " + id + " " + "puesto que varias funciones de cine ya lo contienen");
        }

        sala = salaService.eliminarSala(id);
        return ResponseEntity.ok("Se eliminó la sala con id:"+" "+ id);
    }
}
