package com.example.cine_magic.controllers;

import com.example.cine_magic.exceptions.NotFoundException;
import com.example.cine_magic.exceptions.InvalidDataException;
import com.example.cine_magic.exceptions.IdNotValueException;
import com.example.cine_magic.models.Calificacion;
import com.example.cine_magic.services.CalificacionServiceI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cine_magic_db")
public class CalificacionController {
    @Autowired
    CalificacionServiceI calificacionService;

    //Sí Funciona al 100%, es el normal
    @GetMapping("/calificacion")
    public List<Calificacion> obtenerCalificacion() {return calificacionService.obtenerCalificacion();
    }

    //Sí Funciona al 100%
    @GetMapping("/calificacion/{id}")
    public Calificacion obtenerCalificacionPorId(@PathVariable Long id) {
        Calificacion calificacion;
        if(id < 1){
            throw new IdNotValueException("El id-espectador debe ser númerico y mayor a 0", "err-81", HttpStatus.BAD_REQUEST);
        }
        calificacion = calificacionService.obtenerCalificacionPorId(id);
        if(calificacion == null){
            throw new NotFoundException("No se encontró ningún espectador con id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(calificacion).getBody();
    }


    //Sí Funciona al 100%
    @PostMapping("/calificacion")
    public Calificacion crearCalificacion(@Valid @RequestBody Calificacion calificacion, BindingResult resultado) {
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.NOT_FOUND, resultado);
        }
        return calificacionService.crearCalificacion(calificacion);
    }


    //Sí Funciona al 100%

    @PutMapping("/calificacion/{id}")
    public Calificacion actualizarCalificacion(@PathVariable Long id, @Valid  @RequestBody Calificacion calificacionModificado, BindingResult resultado) {
        Calificacion calificacion;
        if(id < 1){
            throw new IdNotValueException("El id-espectador debe ser númerico y mayor a 0", "err-81",HttpStatus.BAD_REQUEST);
        }
        calificacion = calificacionService.obtenerCalificacionPorId(id);
        if(calificacion == null){
            throw new NotFoundException("No se encontró ningún espectador con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.BAD_REQUEST, resultado);
        }
        calificacion = calificacionService.actualizarCalificacion(id, calificacionModificado);
        return calificacion;
    }

    //Sí Funciona al 100%
    @DeleteMapping("/calificacion/{id}")
    public ResponseEntity<String> eliminarCalificacion(@PathVariable Long id){
        Calificacion calificacion;
        if(id < 1){
            throw new IdNotValueException("El id-espectador debe ser númerico y mayor a 0", "err-81",HttpStatus.BAD_REQUEST);
        }
        calificacion = calificacionService.obtenerCalificacionPorId(id);
        if(calificacion == null){
            throw new NotFoundException("No se encontró ningún espectador con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        calificacion = calificacionService.eliminarCalificacion(id);
        return ResponseEntity.ok("Se eliminó el espectador con id:"+" "+ id);
    }
}
