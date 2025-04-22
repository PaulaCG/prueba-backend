package com.paula.empleadosreportesapi.dto;

public class EstadisticasPaisResponse {

    private String countryName;
    private Long cantidadEmpleados;
    private Double salarioPromedio;
    private Double salarioMaximo;
    private Double salarioMinimo;
    private Double antiguedadPromedio;

    public EstadisticasPaisResponse(String countryName, Long cantidadEmpleados, Double salarioPromedio, Double salarioMaximo, Double salarioMinimo, Double antiguedadPromedio) {
        this.countryName = countryName;
        this.cantidadEmpleados = cantidadEmpleados;
        this.salarioPromedio = salarioPromedio;
        this.salarioMaximo = salarioMaximo;
        this.salarioMinimo = salarioMinimo;
        this.antiguedadPromedio = antiguedadPromedio;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(Long cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }
}