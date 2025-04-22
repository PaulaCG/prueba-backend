package com.paula.empleadosreportesapi.dto;

public class SegmentoDepartamentoResponse {

    private String departamento;
    private String segmentoSalarial;
    private Long cantidadEmpleados;

    public SegmentoDepartamentoResponse(String departamento, String segmentoSalarial, Long cantidadEmpleados) {
        this.departamento = departamento;
        this.segmentoSalarial = segmentoSalarial;
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
