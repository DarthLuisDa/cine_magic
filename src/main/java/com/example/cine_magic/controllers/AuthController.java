package com.example.cine_magic.controllers;

import com.example.cine_magic.models.Auth;
import com.example.cine_magic.models.Usuario;
import com.example.cine_magic.services.AuthServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cine_magic_db/auth")
public class AuthController {
    @Autowired
    AuthServiceI authService;

    @PostMapping("/login")
    public ResponseEntity<Auth> login(@RequestBody Usuario usuario){
        Auth auth = authService.login(usuario);
        return ResponseEntity.ok(auth);
    }

    @PostMapping("/registro")
    public ResponseEntity<Auth> registro(@RequestBody Usuario usuario){
        Auth auth = authService.registro(usuario);
        return ResponseEntity.ok(auth);
    }

    /*
    @PostMapping("/autentification")
    public String obtenerJwt(){
        return "Obteniendo JWT desde endpoint público";
    }
     */
}

