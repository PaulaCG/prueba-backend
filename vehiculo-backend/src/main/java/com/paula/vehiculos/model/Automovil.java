package com.paula.vehiculos.model;

import jakarta.persistence.Entity;

@Entity
public class Automovil extends Vehiculo {

    private String tipo; //hatchback, sedan, etc, es decir un string
    private int numeroPuertas;
    private int capacidadPasajeros;
    private int capacidadMaletero; // litros

    // Getters y Setters

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getNumeroPuertas() { return numeroPuertas; }
    public void setNumeroPuertas(int numeroPuertas) { this.numeroPuertas = numeroPuertas; }

    public int getCapacidadPasajeros() { return capacidadPasajeros; }
    public void setCapacidadPasajeros(int capacidadPasajeros) { this.capacidadPasajeros = capacidadPasajeros; }

    public int getCapacidadMaletero() { return capacidadMaletero; }
    public void setCapacidadMaletero(int capacidadMaletero) { this.capacidadMaletero = capacidadMaletero; }
}
