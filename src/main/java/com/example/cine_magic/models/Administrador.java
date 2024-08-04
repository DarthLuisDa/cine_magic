package com.example.cine_magic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Administradores")
public class Administrador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "El id-administrador no debe ser null")
    @NotEmpty(message = "El id-administrador no debe estar vacío")
    @Column(name = "ID_Administrador", nullable = false)
    private String ID_Administrador;

    @NotNull(message = "El nombre_administrador no debe ser null")
    @NotEmpty(message = "El nombre_administrador no debe estar vacío")
    @Column(name = "Nombre_Administrador", nullable = false)
    private String Nombre_Administrador;

    @Email(message = "El correo_administrador debe ser válido")
    @NotNull(message = "El correo_administrador no debe ser null")
    @NotEmpty(message = "El correo_administrador no debe estar vacío")
    @Column(name = "Correo_Administrador", nullable = false)
    private String Correo_Administrador;

    @NotNull(message = "La contraseña_administrador no debe ser null")
    @NotEmpty(message = "La contraseña_administrador no debe estar vacío")
    @Column(name = "Contraseña_Administrador", nullable = false)
    private String Contrasena_Administrador;

    public Administrador() {
    }

    public Administrador(String ID_Administrador, String nombre_Administrador, String correo_Administrador, String contrasena_Administrador) {
        this.ID_Administrador = ID_Administrador;
        Nombre_Administrador = nombre_Administrador;
        Correo_Administrador = correo_Administrador;
        Contrasena_Administrador = contrasena_Administrador;
    }

    public String getID_Administrador() {
        return ID_Administrador;
    }

    public void setID_Administrador(String ID_Administrador) {
        this.ID_Administrador = ID_Administrador;
    }

    public String getNombre_Administrador() {
        return Nombre_Administrador;
    }

    public void setNombre_Administrador(String nombre_Administrador) {
        Nombre_Administrador = nombre_Administrador;
    }

    public String getCorreo_Administrador() {
        return Correo_Administrador;
    }

    public void setCorreo_Administrador(String correo_Administrador) {
        Correo_Administrador = correo_Administrador;
    }

    public String getContrasena_Administrador() {
        return Contrasena_Administrador;
    }

    public void setContrasena_Administrador(String contrasena_Administrador) {
        Contrasena_Administrador = contrasena_Administrador;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "ID_Administrador=" + ID_Administrador +
                ", Nombre_Administrador='" + Nombre_Administrador + '\'' +
                ", Correo_Administrador='" + Correo_Administrador + '\'' +
                ", Contrasena_Administrador='" + Contrasena_Administrador + '\'' +
                '}';
    }
}
