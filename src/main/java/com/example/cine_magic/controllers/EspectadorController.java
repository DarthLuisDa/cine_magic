package com.example.cine_magic.controllers;

import com.example.cine_magic.exceptions.NotFoundException;
import com.example.cine_magic.exceptions.InvalidDataException;
import com.example.cine_magic.exceptions.IdNotValueException;
import com.example.cine_magic.models.Espectador;
import com.example.cine_magic.services.EspectadorServiceI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cine_magic_db")
public class EspectadorController {
    @Autowired
    EspectadorServiceI espectadorService;

    //Sí Funciona al 100%, es el normal
    @GetMapping("/espectador")
    public List<Espectador> obtenerEspectador() {return espectadorService.obtenerEspectador();
    }

    //Sí Funciona al 100%
    @GetMapping("/espectador/{id}")
    public Espectador obtenerEspectadorPorId(@PathVariable Long id) {
        Espectador espectador;
        if(id < 1){
            throw new IdNotValueException("El id-espectador debe ser númerico y mayor a 0", "err-81", HttpStatus.BAD_REQUEST);
        }
        espectador = espectadorService.obtenerEspectadorPorId(id);
        if(espectador == null){
            throw new NotFoundException("No se encontró ningún espectador con id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(espectador).getBody();
    }


    //Sí Funciona al 100%
    @PostMapping("/espectador")
    public ResponseEntity<String> crearEspectador(@Valid @RequestBody Espectador espectador, BindingResult resultado) {
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.NOT_FOUND, resultado);
        }
        espectador = espectadorService.crearEspectador(espectador);
        return ResponseEntity.ok("Se creó:"+ espectador);
    }


    //Sí Funciona al 100%

    @PutMapping("/espectador/{id}")
    public ResponseEntity<String> actualizarEspectador(@PathVariable Long id, @Valid  @RequestBody Espectador espectadorModificado, BindingResult resultado) {
        Espectador espectador;
        if(id < 1){
            throw new IdNotValueException("El id-espectador debe ser númerico y mayor a 0", "err-81",HttpStatus.BAD_REQUEST);
        }
        espectador = espectadorService.obtenerEspectadorPorId(id);
        if(espectador == null){
            throw new NotFoundException("No se encontró ningún espectador con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.BAD_REQUEST, resultado);
        }
        espectador = espectadorService.actualizarEspectador(id, espectadorModificado);
        return ResponseEntity.ok("Se modificó el administrador con id:"+" "+ id);
    }

    //Sí Funciona al 100%
    @DeleteMapping("/espectador/{id}")
    public ResponseEntity<String> eliminarEspectador(@PathVariable Long id){
        Espectador espectador;
        if(id < 1){
            throw new IdNotValueException("El id-espectador debe ser númerico y mayor a 0", "err-81",HttpStatus.BAD_REQUEST);
        }
        espectador = espectadorService.obtenerEspectadorPorId(id);
        if(espectador == null){
            throw new NotFoundException("No se encontró ningún espectador con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        espectador = espectadorService.eliminarEspectador(id);
        return ResponseEntity.ok("Se eliminó el espectador con id:"+" "+ id);
    }
}
