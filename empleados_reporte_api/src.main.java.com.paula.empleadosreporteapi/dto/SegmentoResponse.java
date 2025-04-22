package com.paula.empleadosreportesapi.dto;

public class SegmentoResponse {

    private String segmentoSalarial;
    private Long cantidadEmpleados;

    public SegmentoResponse(String segmentoSalarial, Long cantidadEmpleados) {
        this.segmentoSalarial = segmentoSalarial;
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public String getSegmentoSalarial() {
        return segmentoSalarial;
    }

    public void setSegmentoSalarial(String segmentoSalarial) {
        this.segmentoSalarial = segmentoSalarial;
    }

    public Long getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(Long cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }
}
