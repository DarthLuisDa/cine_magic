package com.example.cine_magic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Espectadores")
public class Espectador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "El id-espectador no debe ser null")
    @NotEmpty(message = "El id-espectador no debe estar vacío")
    @Column(name = "ID_Espectador", nullable = false)
    private String ID_Espectador;

    @NotNull(message = "El nombre_espectador no debe ser null")
    @NotEmpty(message = "El nombre_espectador no debe estar vacío")
    @Column(name = "Nombre_Espectador", nullable = false)
    private String Nombre_Espectador;

    @Email(message = "El correo_espectador debe ser válido")
    @NotNull(message = "El correo_espectador no debe ser null")
    @NotEmpty(message = "El correo_espectador no debe estar vacío")
    @Column(name = "Correo_Espectador", nullable = false)
    private String Correo_Espectador;

    @NotNull(message = "La contraseña_espectador no debe ser null")
    @NotEmpty(message = "La contraseña_espectador no debe estar vacío")
    @Column(name = "Contraseña_Espectador", nullable = false)
    private String Contrasena_Espectador;

    public Espectador() {
    }

    public Espectador(String ID_Espectador, String nombre_Espectador, String correo_Espectador, String contrasena_Espectador) {
        this.ID_Espectador = ID_Espectador;
        Nombre_Espectador = nombre_Espectador;
        Correo_Espectador = correo_Espectador;
        Contrasena_Espectador = contrasena_Espectador;
    }

    public String getID_Espectador() {
        return ID_Espectador;
    }

    public void setID_Espectador(String ID_Espectador) {
        this.ID_Espectador = ID_Espectador;
    }

    public String getNombre_Espectador() {
        return Nombre_Espectador;
    }

    public void setNombre_Espectador(String nombre_Espectador) {
        Nombre_Espectador = nombre_Espectador;
    }

    public String getCorreo_Espectador() {
        return Correo_Espectador;
    }

    public void setCorreo_Espectador(String correo_Espectador) {
        Correo_Espectador = correo_Espectador;
    }

    public String getContrasena_Espectador() {
        return Contrasena_Espectador;
    }

    public void setContrasena_Espectador(String contrasena_Espectador) {
        Contrasena_Espectador = contrasena_Espectador;
    }

    @Override
    public String toString() {
        return "Espectador{" +
                "ID_Espectador=" + ID_Espectador +
                ", Nombre_Espectador='" + Nombre_Espectador + '\'' +
                ", Correo_Espectador='" + Correo_Espectador + '\'' +
                ", Contrasena_Espectador='" + Contrasena_Espectador + '\'' +
                '}';
    }
}