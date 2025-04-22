package com.paula.vehiculos.model;

import jakarta.persistence.Entity;

@Entity
public class Camion extends Vehiculo {

    private String tipo; // ¾, tolva, etc, se asignaran como strings aunque se ingresen como números
    private double capacidadToneladas;
    private int cantidadEjes;

    // Getters y Setters

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getCapacidadToneladas() { return capacidadToneladas; }
    public void setCapacidadToneladas(double capacidadToneladas) { this.capacidadToneladas = capacidadToneladas; }

    public int getCantidadEjes() { return cantidadEjes; }
    public void setCantidadEjes(int cantidadEjes) { this.cantidadEjes = cantidadEjes; }
}
