package com.example.cine_magic.services;

import org.springframework.security.authentication.AuthenticationManager;
import com.example.cine_magic.models.Auth;
import com.example.cine_magic.models.Usuario;
import com.example.cine_magic.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthServiceI {

    @Autowired
    UsuarioRepository usuarioRepository;

    private final JwtServiceImp jwtServiceImp;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public AuthServiceImp(JwtServiceImp jwtServiceImp, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.jwtServiceImp = jwtServiceImp;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Auth login(Usuario usuario) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));
        UserDetails userDetails = usuarioRepository.findByUsername(usuario.getUsername()).orElseThrow();
        String token = jwtServiceImp.getToken(userDetails);
        Auth auth = new Auth();
        auth.setToken(token);
        return auth ;


    }

    @Override
    public Auth registro(Usuario usuario) {
        Usuario usuarioAguardar = new Usuario();
        usuarioAguardar.setId(usuario.getId());
        usuarioAguardar.setUsername(usuario.getUsername());
        usuarioAguardar.setPassword(passwordEncoder.encode(usuario.getPassword())); //se encripta la contraseña
        usuarioAguardar.setRol(usuario.getRol());
        usuarioRepository.save(usuarioAguardar);

        Auth auth = new Auth();
        auth.setToken(jwtServiceImp.getToken(usuario));
        return auth;
    }
}
