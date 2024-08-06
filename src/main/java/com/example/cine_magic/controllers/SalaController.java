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
    public ResponseEntity<String> crearSala(@Valid @RequestBody Sala sala, BindingResult resultado) {
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.NOT_FOUND, resultado);
        }
        sala = salaService.crearSala(sala);
        return ResponseEntity.ok("Se creó:"+ sala);
    }


    //Sí Funciona al 100%

    @PutMapping("/sala/{id}")
    public ResponseEntity<String> actualizarSala(@PathVariable Long id, @Valid  @RequestBody Sala salaModificada, BindingResult resultado) {
        Sala sala;
        if(id < 1){
            throw new IdNotValueException("El id-sala debe ser númerico y mayor a 0", "err-84",HttpStatus.BAD_REQUEST);
        }
        if(id < 11) {
            return ResponseEntity.badRequest().body("No se puede modificar el id-sala:" + " " + id + " " + "puesto que varias funciones y boletos de cine ya lo contienen");
        }
        sala = salaService.obtenerSalaPorId(id);
        if(sala == null){
            throw new NotFoundException("No se encontró ninguna sala con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.BAD_REQUEST, resultado);
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
        if(id < 11){
            return ResponseEntity.badRequest().body("No se puede eliminar el id-sala:"+" "+ id +" "+"puesto que varias funciones y boletos de cine ya lo contienen");
        }
        sala = salaService.obtenerSalaPorId(id);
        if(sala == null){
            throw new NotFoundException("No se encontró ninguna sala con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        sala = salaService.eliminarSala(id);
        return ResponseEntity.ok("Se eliminó la sala con id:"+" "+ id);
    }
}
