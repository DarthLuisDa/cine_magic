package com.example.cine_magic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Películas")
public class Pelicula {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "El id-película no debe ser null")
    @NotEmpty(message = "El id-película no debe estar vacío")
    @Column(name = "ID_Película", nullable = false)
    private String ID_Pelicula;

    @NotNull(message = "El título no debe ser null")
    @NotEmpty(message = "El título no debe estar vacío")
    @Column(name = "Título", nullable = false)
    private String Titulo;

    @NotNull(message = "El género no debe ser null")
    @NotEmpty(message = "El género no debe estar vacío")
    @Column(name = "Género", nullable = false)
    private String Genero;

    @NotNull(message = "La duración no debe ser null")
    @NotEmpty(message = "La duración no debe estar vacía")
    @Column(name = "Duración", nullable = false)
    private String Duracion;


    @NotNull(message = "La clasificación no debe ser null")
    @NotEmpty(message = "La clasificación no debe estar vacía")
    @Column(name = "Clasificación", nullable = false)
    private String Clasificacion;

    @NotNull(message = "La sinópsis no debe ser null")
    @NotEmpty(message = "La sinópsis no debe estar vacía")
    @Column(name = "Sinópsis", nullable = false)
    private String Sinopsis;

    @NotNull(message = "El director no debe ser null")
    @NotEmpty(message = "El director no debe estar vacío")
    @Column(name = "Director", nullable = false)
    private String Director;

    public Pelicula() {
    }

    public Pelicula(String ID_Pelicula, String titulo, String genero, String duracion, String clasificacion, String sinopsis, String director) {
        this.ID_Pelicula = ID_Pelicula;
        Titulo = titulo;
        Genero = genero;
        Duracion = duracion;
        Clasificacion = clasificacion;
        Sinopsis = sinopsis;
        Director = director;
    }

    public String getID_Película() {
        return ID_Pelicula;
    }

    public void setID_Película(String ID_Película) {
        this.ID_Pelicula = ID_Película;
    }

    public String getTítulo(String s) {
        return Titulo;
    }

    public void setTítulo(String título) {
        Titulo = título;
    }

    public String getGénero() {
        return Genero;
    }

    public void setGénero(String género) {
        Genero = género;
    }

    public String getDuración() {
        return Duracion;
    }

    public void setDuración(String duración) {
        Duracion = duración;
    }

    public String getClasificación() {
        return Clasificacion;
    }

    public void setClasificación(String clasificación) {
        Clasificacion = clasificación;
    }

    public String getSinópsis() {
        return Sinopsis;
    }

    public void setSinópsis(String sinópsis) {
        Sinopsis = sinópsis;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "ID_Película=" + ID_Pelicula +
                ", Título='" + Titulo + '\'' +
                ", Género='" + Genero + '\'' +
                ", Duración='" + Duracion + '\'' +
                ", Clasificación='" + Clasificacion + '\'' +
                ", Sinópsis='" + Sinopsis + '\'' +
                ", Director='" + Director + '\'' +
                '}';
    }
}
