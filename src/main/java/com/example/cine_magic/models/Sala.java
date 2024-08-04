package com.example.cine_magic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Salas")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "El id-sala no debe estar vacío")
    @NotNull(message = "El id-sala no debe ser null")
    @Column(name = "ID_Sala", nullable = false)
    private String ID_Sala;

    public Sala() {
    }

    public Sala(String ID_Sala) {
        this.ID_Sala = ID_Sala;
    }

    public String getID_Sala() {
        return ID_Sala;
    }

    public void setID_Sala(String ID_Sala) {
        this.ID_Sala = ID_Sala;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "ID_Sala='" + ID_Sala + '\'' +
                '}';
    }
}
