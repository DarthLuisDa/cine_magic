package com.example.cine_magic.controllers;

import com.example.cine_magic.exceptions.NotFoundException;
import com.example.cine_magic.exceptions.InvalidDataException;
import com.example.cine_magic.exceptions.IdNotValueException;
import com.example.cine_magic.models.Pelicula;
import com.example.cine_magic.services.PeliculaServiceI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cine_magic_db")
public class PeliculaController {
    @Autowired
    PeliculaServiceI peliculaService;

    //Sí Funciona al 100%, es el normal
    @GetMapping("/pelicula")
    public List<Pelicula> obtenerPelicula() {return peliculaService.obtenerPelicula();
    }

    //Sí Funciona al 100%
    @GetMapping("/pelicula/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable Long id) {
        Pelicula pelicula;
        if(id < 1){
            throw new IdNotValueException("El id-pelicula debe ser númerico y mayor a 0", "err-24", HttpStatus.BAD_REQUEST);
        }
        pelicula = peliculaService.obtenerPeliculaPorId(id);
        if(pelicula == null){
            throw new NotFoundException("No se encontró ninguna película con id:"+" "+ id,"err-25",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pelicula).getBody();
    }


    //Sí Funciona al 100%
    @PostMapping("/pelicula")
    public ResponseEntity<String> crearPelicula(@Valid @RequestBody Pelicula pelicula, BindingResult resultado) {
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-23",HttpStatus.NOT_FOUND, resultado);
        }
        pelicula = peliculaService.crearPelicula(pelicula);
        return ResponseEntity.ok("Se creó:"+ pelicula);
    }


    //Sí Funciona al 100%

    @PutMapping("/pelicula/{id}")
    public ResponseEntity<String> actualizarPelicula(@PathVariable Long id, @Valid  @RequestBody Pelicula peliculaModificada, BindingResult resultado) {
        Pelicula pelicula;
        if(id < 1){
            throw new IdNotValueException("El id-pelicula debe ser númerico y mayor a 0", "err-24",HttpStatus.BAD_REQUEST);
        }
        if(id <= 4) {
            return ResponseEntity.badRequest().body("No se puede modificar el id-pelicula:" + " " + id + " " + "puesto que varias funciones y boletos de cine ya lo contienen");
        }
        pelicula = peliculaService.obtenerPeliculaPorId(id);
        if(pelicula == null){
            throw new NotFoundException("No se encontró ninguna película con ese id:"+" "+ id,"err-25",HttpStatus.NOT_FOUND);
        }
        //Manejar los: @NotNull y los @NotEmpty
        if(resultado.hasErrors()){
            throw new InvalidDataException("Error de validación - Favor de revisar los datos introducidos", "err-23",HttpStatus.BAD_REQUEST, resultado);
        }
        pelicula = peliculaService.actualizarPelicula(id, peliculaModificada);
        return ResponseEntity.ok("Se modificó la pelicula con id:"+" "+ id);
    }

    //Sí Funciona al 100%
    @DeleteMapping("/pelicula/{id}")
    public ResponseEntity<String> eliminarPelicula(@PathVariable Long id){
        Pelicula pelicula;
        if(id < 1){
            throw new IdNotValueException("El id-pelicula debe ser númerico y mayor a 0", "err-24",HttpStatus.BAD_REQUEST);
        }
        if(id <= 4 ){
            return ResponseEntity.badRequest().body("No se puede eliminar el id-pelicula:"+" "+ id +" "+"puesto que varias funciones y boletos de cine ya lo contienen");
        }
        pelicula = peliculaService.obtenerPeliculaPorId(id);
        if(pelicula == null){
            throw new NotFoundException("No se encontró ninguna película con ese id:"+" "+ id,"err-25",HttpStatus.NOT_FOUND);
        }
        pelicula = peliculaService.eliminarPelicula(id);
        return ResponseEntity.ok("Se eliminó la película con id:"+" "+ id);
    }
}
