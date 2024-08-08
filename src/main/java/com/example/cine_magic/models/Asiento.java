package com.example.cine_magic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Asientos")
public class Asiento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "El id-asiento no debe ser null")
    @NotEmpty(message = "El id-asiento no debe estar vacío")
    @Column(name = "ID_Asiento", nullable = false)
    private String ID_Asiento;

    @NotNull(message = "La fila no debe ser null")
    @NotEmpty(message = "La fila no debe estar vacía")
    @Column(name = "Fila", nullable = false)
    private String Fila;

    @NotNull(message = "El número no debe ser null")
    @NotEmpty(message = "El número no debe estar vacío")
    @Column(name = "Número", nullable = false)
    private String Numero;

    @NotNull(message = "Disponible no debe ser null")
    @Column(name = "Disponible", nullable = false)
    private Boolean Disponible;

    public Asiento() {
    }

    public Asiento(String ID_Asiento, String fila, String numero, Boolean disponible) {
        this.ID_Asiento = ID_Asiento;
        Fila = fila;
        Numero = numero;
        Disponible = disponible;
    }

    public String getID_Asiento() {
        return ID_Asiento;
    }

    public void setID_Asiento(String ID_Asiento) {
        this.ID_Asiento = ID_Asiento;
    }

    public String getFila(String s) {
        return Fila;
    }

    public void setFila(String fila) {
        Fila = fila;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public Boolean getDisponible() {
        return Disponible;
    }

    public void setDisponible(Boolean disponible) {
        Disponible = disponible;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "ID_Asiento='" + ID_Asiento + '\'' +
                ", Fila='" + Fila + '\'' +
                ", Numero='" + Numero + '\'' +
                ", Disponible=" + Disponible +
                '}';
    }
}

