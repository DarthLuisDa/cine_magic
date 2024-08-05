package com.example.cine_magic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Sucursales")
public class Sucursal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "El id-sucursal no debe ser null")
    @NotEmpty(message = "El id-sucursal no debe estar vacío")
    @Column(name = "ID_Sucursal", nullable = false)
    private String ID_Sucursal;

    @NotNull(message = "El nombre_sucursal no debe ser null")
    @NotEmpty(message = "El nombre_sucursal no debe estar vacío")
    @Column(name = "Nombre_Sucursal", nullable = false)
    private String Nombre_Sucursal;

    @NotNull(message = "La dirección no debe ser null")
    @NotEmpty(message = "La dirección no debe estar vacía")
    @Column(name = "Dirección", nullable = false)
    private String Direccion;

    @NotNull(message = "La ciudad no debe ser null")
    @NotEmpty(message = "La ciudad no debe estar vacía")
    @Column(name = "Ciudad", nullable = false)
    private String Ciudad;

    @NotNull(message = "El estado no debe ser null")
    @NotEmpty(message = "El estado no debe estar vacío")
    @Column(name = "Estado", nullable = false)
    private String Estado;

    public Sucursal() {
    }

    public Sucursal(String ID_Sucursal, String nombre_Sucursal, String direccion, String ciudad, String estado) {
        this.ID_Sucursal = ID_Sucursal;
        Nombre_Sucursal = nombre_Sucursal;
        Direccion = direccion;
        Ciudad = ciudad;
        Estado = estado;
    }

    public String getID_Sucursal() {
        return ID_Sucursal;
    }

    public void setID_Sucursal(String ID_Sucursal) {
        this.ID_Sucursal = ID_Sucursal;
    }

    public String getNombre_Sucursal() {
        return Nombre_Sucursal;
    }

    public void setNombre_Sucursal(String nombre_Sucursal) {
        Nombre_Sucursal = nombre_Sucursal;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "ID_Sucursal='" + ID_Sucursal + '\'' +
                ", Nombre_Sucursal='" + Nombre_Sucursal + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", Ciudad='" + Ciudad + '\'' +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}