package com.example.cine_magic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Calificaciones")
public class Calificacion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "El id-calificación no debe ser null")
    @NotEmpty(message = "El id-calificación no debe estar vacío")
    @Column(name = "ID_Calificación", nullable = false)
    private String ID_Calificacion;

    @NotNull(message = "El fk_id-espectador no debe ser null")
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_ID_Espectador", nullable = false)
    private Espectador FK_ID_Espectador;

    @NotNull(message = "El fk_id-pelicula no debe ser null")
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_ID_Película", nullable = false)
    private Pelicula FK_ID_Pelicula;

    @NotNull(message = "El número_calificación no debe ser null")
    @NotEmpty(message = "El número_calificación no debe estar vacío")
    @Column(name = "Número_Calificación", nullable = false)
    private String Numero_Calificacion;

    @NotNull(message = "La reseña no debe ser null")
    @NotEmpty(message = "La reseña no debe estar vacía")
    @Column(name = "Reseña", nullable = false)
    private String Resena;

    public Calificacion() {
    }

    public Calificacion(String ID_Calificacion, Espectador FK_ID_Espectador, Pelicula FK_ID_Pelicula, String numero_Calificacion, String resena) {
        this.ID_Calificacion = ID_Calificacion;
        this.FK_ID_Espectador = FK_ID_Espectador;
        this.FK_ID_Pelicula = FK_ID_Pelicula;
        Numero_Calificacion = numero_Calificacion;
        Resena = resena;
    }

    public String getID_Calificacion() {
        return ID_Calificacion;
    }

    public void setID_Calificacion(String ID_Calificacion) {
        this.ID_Calificacion = ID_Calificacion;
    }

    public Espectador getFK_ID_Espectador() {
        return FK_ID_Espectador;
    }

    public void setFK_ID_Espectador(Espectador FK_ID_Espectador) {
        this.FK_ID_Espectador = FK_ID_Espectador;
    }

    public Pelicula getFK_ID_Pelicula() {
        return FK_ID_Pelicula;
    }

    public void setFK_ID_Pelicula(Pelicula FK_ID_Pelicula) {
        this.FK_ID_Pelicula = FK_ID_Pelicula;
    }

    public String getNumero_Calificacion() {
        return Numero_Calificacion;
    }

    public void setNumero_Calificacion(String numero_Calificacion) {
        Numero_Calificacion = numero_Calificacion;
    }

    public String getResena() {
        return Resena;
    }

    public void setResena(String resena) {
        Resena = resena;
    }

    @Override
    public String toString() {
        return "Calificacion{" +
                "ID_Calificacion=" + ID_Calificacion +
                ", FK_ID_Espectador=" + FK_ID_Espectador +
                ", FK_ID_Pelicula=" + FK_ID_Pelicula +
                ", Numero_Calificacion='" + Numero_Calificacion + '\'' +
                ", Resena='" + Resena + '\'' +
                '}';
    }
}
