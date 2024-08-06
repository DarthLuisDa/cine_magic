package com.example.cine_magic.controllers;

import com.example.cine_magic.exceptions.NotFoundException;
import com.example.cine_magic.exceptions.InvalidDataException;
import com.example.cine_magic.exceptions.IdNotValueException;
import com.example.cine_magic.models.Administrador;
import com.example.cine_magic.services.AdministradorServiceI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cine_magic_db")
public class AdministradorController {
    @Autowired
    AdministradorServiceI administradorService;

    //Sí Funciona al 100%, es el normal
    @GetMapping("/administrador")
    public List<Administrador> obtenerAdministrador() {return administradorService.obtenerAdministrador();
    }

    //Sí Funciona al 100%
    @GetMapping("/administrador/{id}")
    public Administrador obtenerAdministradorPorId(@PathVariable Long id) {
        Administrador administrador;
        if(id < 1){
            throw new IdNotValueException("El id-administrador debe ser númerico y mayor a 0", "err-81", HttpStatus.BAD_REQUEST);
        }
        administrador = administradorService.obtenerAdministradorPorId(id);
        if(administrador == null){
            throw new NotFoundException("No se encontró ningún administrador con id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(administrador).getBody();
    }


    //Sí Funciona al 100%
    @PostMapping("/administrador")
    public ResponseEntity<String> crearAdministrador(@Valid @RequestBody Administrador administrador, BindingResult resultado) {
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.NOT_FOUND, resultado);
        }
        administrador = administradorService.crearAdministrador(administrador);
        return ResponseEntity.ok("Se creó:"+ administrador);
    }


    //Sí Funciona al 100%

    @PutMapping("/administrador/{id}")
    public ResponseEntity<String> actualizarAdministrador(@PathVariable Long id, @Valid  @RequestBody Administrador administradorModificado, BindingResult resultado) {
        Administrador administrador;
        if(id < 1){
            throw new IdNotValueException("El id-administrador debe ser númerico y mayor a 0", "err-81",HttpStatus.BAD_REQUEST);
        }
        administrador = administradorService.obtenerAdministradorPorId(id);
        if(administrador == null){
            throw new NotFoundException("No se encontró ningún administrador con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-83",HttpStatus.BAD_REQUEST, resultado);
        }
        administrador = administradorService.actualizarAdministrador(id, administradorModificado);
        return ResponseEntity.ok("Se modificó el administrador con id:"+" "+ id);
    }

    //Sí Funciona al 100%
    @DeleteMapping("/administrador/{id}")
    public ResponseEntity<String> eliminarEspectador(@PathVariable Long id){
        Administrador administrador;
        if(id < 1){
            throw new IdNotValueException("El id-administrador debe ser númerico y mayor a 0", "err-81",HttpStatus.BAD_REQUEST);
        }
        administrador = administradorService.obtenerAdministradorPorId(id);
        if(administrador == null){
            throw new NotFoundException("No se encontró ningún administrador con ese id:"+" "+ id,"err-82",HttpStatus.NOT_FOUND);
        }
        administrador = administradorService.eliminarAdministrador(id);
        return ResponseEntity.ok("Se eliminó el administrador con id:"+" "+ id);
    }
}
