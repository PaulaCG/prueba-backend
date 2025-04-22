package com.paula.empleadosreportesapi.dto;

import java.time.LocalDate;

public class GerenteAntiguoResponse {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String jobId;
    private Double salary;
    private LocalDate hireDate;

    public GerenteAntiguoResponse(Long employeeId, String firstName, String lastName, String jobId, Double salary, LocalDate hireDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobId = jobId;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
