package com.example.cine_magic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Boletos")
public class Boleto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "El id-boleto no debe ser null")
    @NotEmpty(message = "El id-boleto no debe estar vacío")
    @Column(name = "ID_Boleto", nullable = false)
    private String ID_Boleto;

    @NotNull(message = "El fk_id_función no debe ser null")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_ID_Función", nullable = false)
    private Funcion FK_ID_Funcion;

    @NotNull(message = "El fk_id_asiento no debe ser null")
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_ID_Asiento", nullable = false)
    private Asiento FK_ID_Asiento;

    @NotNull(message = "El precio no debe ser null")
    @NotEmpty(message = "El precio no debe estar vacío")
    @Column(name = "Precio", nullable = false)
    private String Precio;

    public Boleto() {
    }

    public Boleto(String ID_Boleto, Funcion FK_ID_Funcion, Asiento FK_ID_Asiento, String precio) {
        this.ID_Boleto = ID_Boleto;
        this.FK_ID_Funcion = FK_ID_Funcion;
        this.FK_ID_Asiento = FK_ID_Asiento;
        Precio = precio;
    }

    public String getID_Boleto() {
        return ID_Boleto;
    }

    public void setID_Boleto(String ID_Boleto) {
        this.ID_Boleto = ID_Boleto;
    }

    public Funcion getFK_ID_Funcion() {
        return FK_ID_Funcion;
    }

    public void setFK_ID_Funcion(Funcion FK_ID_Funcion) {
        this.FK_ID_Funcion = FK_ID_Funcion;
    }

    public Asiento getFK_ID_Asiento() {
        return FK_ID_Asiento;
    }

    public void setFK_ID_Asiento(Asiento FK_ID_Asiento) {
        this.FK_ID_Asiento = FK_ID_Asiento;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "ID_Boleto=" + ID_Boleto +
                ", FK_ID_Funcion=" + FK_ID_Funcion +
                ", FK_ID_Asiento=" + FK_ID_Asiento +
                ", Precio='" + Precio + '\'' +
                '}';
    }
}

