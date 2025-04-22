package com.paula.empleadosreportesapi.dto;

public class SalarioPromedioDepartamentoResponse {

    private String departmentName;
    private Double salarioPromedio;
    private Long cantidadEmpleados;

    public SalarioPromedioDepartamentoResponse(String departmentName, Double salarioPromedio, Long cantidadEmpleados) {
        this.departmentName = departmentName;
        this.salarioPromedio = salarioPromedio;
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Double getSalarioPromedio() {
        return salarioPromedio;
    }

    public void setSalarioPromedio(Double salarioPromedio) {
        this.salarioPromedio = salarioPromedio;
    }

    public Long getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(Long cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }
}
