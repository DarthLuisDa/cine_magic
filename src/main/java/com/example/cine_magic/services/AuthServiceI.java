package com.example.cine_magic.services;

import com.example.cine_magic.models.Auth;
import com.example.cine_magic.models.Usuario;

public interface AuthServiceI{
    Auth login(Usuario usuario);
    Auth registro(Usuario usuario);
}
