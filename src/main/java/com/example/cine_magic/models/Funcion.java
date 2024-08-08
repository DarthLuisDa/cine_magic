package com.example.cine_magic.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Funciones")
public class Funcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "La id-función no debe ser null")
    @NotEmpty(message = "La id-función no debe estar vacía")
    @Column(name = "ID_Función", nullable = false)
    private String ID_Función;

    @NotNull(message = "El fk_id_película no debe ser null")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_ID_Película", nullable = false)
    private Pelicula FK_ID_Película;

    @NotNull(message = "El fk_id_sucursal no debe ser null")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_ID_Sucursal", nullable = false)
    private Sucursal FK_ID_Sucursal;

    //No necesita la cascada puesto que solo existe la llave primaria o ID
    //Aqui si puedo implementar el @NotEmpty porque es de tipo String
    @NotNull(message = "El fk_id_sala no debe ser null")
    @NotEmpty(message = "El fk_id_sala no debe estar vacío")
    @JoinColumn(name = "FK_ID_Sala", nullable = false)
    private String FK_ID_Sala;

    @NotNull(message = "El horario no debe ser null")
    @NotEmpty(message = "El horario no debe estar vacío")
    @Column(name = "Horario", nullable = false)
    private String Horario;

    public Funcion() {
    }

    public Funcion(String ID_Función, Pelicula FK_ID_Película, Sucursal FK_ID_Sucursal, String FK_ID_Sala, String horario) {
        this.ID_Función = ID_Función;
        this.FK_ID_Película = FK_ID_Película;
        this.FK_ID_Sucursal = FK_ID_Sucursal;
        this.FK_ID_Sala = FK_ID_Sala;
        Horario = horario;
    }

    public String getID_Función() {
        return ID_Función;
    }

    public void setID_Función(String ID_Función) {
        this.ID_Función = ID_Función;
    }

    public Pelicula getFK_ID_Película(String s) {
        return FK_ID_Película;
    }

    public void setFK_ID_Película(Pelicula FK_ID_Película) {
        this.FK_ID_Película = FK_ID_Película;
    }

    public Sucursal getFK_ID_Sucursal() {
        return FK_ID_Sucursal;
    }

    public void setFK_ID_Sucursal(Sucursal FK_ID_Sucursal) {
        this.FK_ID_Sucursal = FK_ID_Sucursal;
    }

    public String getFK_ID_Sala() {
        return FK_ID_Sala;
    }

    public void setFK_ID_Sala(String FK_ID_Sala) {
        this.FK_ID_Sala = FK_ID_Sala;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "ID_Función='" + ID_Función + '\'' +
                ", FK_ID_Película=" + FK_ID_Película +
                ", FK_ID_Sucursal=" + FK_ID_Sucursal +
                ", FK_ID_Sala='" + FK_ID_Sala + '\'' +
                ", Horario='" + Horario + '\'' +
                '}';
    }
}



