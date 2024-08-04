package com.example.cine_magic.controllers;

import com.example.cine_magic.exceptions.IdNotValueException;
import com.example.cine_magic.exceptions.InvalidDataException;
import com.example.cine_magic.exceptions.NotFoundException;
import com.example.cine_magic.models.Boleto;
import com.example.cine_magic.services.BoletoServiceI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cine_magic_db")
public class BoletoController {
    @Autowired
    BoletoServiceI boletoService;

    //Sí Funciona al 100%, es el normal
    @GetMapping("/boleto")
    public List<Boleto> obtenerBoleto() {return boletoService.obtenerBoleto();
    }

    //Sí Funciona al 100%
    @GetMapping("/boleto/{id}")
    public Boleto obtenerBoletoPorId(@PathVariable Long id) {
        Boleto boleto;
        if(id < 1){
            throw new IdNotValueException("El id-boleto debe ser númerico y mayor a 0", "err-84", HttpStatus.BAD_REQUEST);
        }
        boleto = boletoService.obtenerBoletoPorId(id);
        if(boleto == null){
            throw new NotFoundException("No se encontró ningún boleto con id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(boleto).getBody();
    }


    //Sí Funciona al 100%
    @PostMapping("/boleto")
    public Boleto crearBoleto(@Valid @RequestBody Boleto boleto, BindingResult resultado) {
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.NOT_FOUND, resultado);
        }
        return boletoService.crearBoleto(boleto);
    }


    //Sí Funciona al 100%

    @PutMapping("/boleto/{id}")
    public Boleto actualizarBoleto(@PathVariable Long id, @Valid  @RequestBody Boleto boletoModificado, BindingResult resultado) {
        Boleto boleto;
        if(id < 1){
            throw new IdNotValueException("El id-boleto debe ser númerico y mayor a 0", "err-84",HttpStatus.BAD_REQUEST);
        }
        boleto = boletoService.obtenerBoletoPorId(id);
        if(boleto == null){
            throw new NotFoundException("No se encontró ningún boleto con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.BAD_REQUEST, resultado);
        }
        boleto = boletoService.actualizarBoleto(id, boletoModificado);
        return boleto;
    }

    //Sí Funciona al 100%
    @DeleteMapping("/boleto/{id}")
    public ResponseEntity<String> eliminarBoleto(@PathVariable Long id){
        Boleto boleto;
        if(id < 1){
            throw new IdNotValueException("El id-boleto debe ser númerico y mayor a 0", "err-84",HttpStatus.BAD_REQUEST);
        }
        boleto = boletoService.obtenerBoletoPorId(id);
        if(boleto == null){
            throw new NotFoundException("No se encontró ningún boleto con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        boleto = boletoService.eliminarBoleto(id);
        return ResponseEntity.ok("Se eliminó el boleto con id:"+" "+ id);
    }
}