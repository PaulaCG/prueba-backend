package com.paula.empleadosreportesapi.controller;

import com.paula.empleadosreportesapi.dto.SegmentoResponse;
import com.paula.empleadosreportesapi.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * Endpoint relacionado con la consulta i-- de la Parte 2 (MySQL):
     *
     * "Obtener cantidad de empleados dentro de los siguientes segmentos de sueldo:
     *  - Segmento A: menor a USD 3.500
     *  - Segmento B: entre USD 3.500 y 7.999
     *  - Segmento C: mayor o igual a USD 8.000"
     *
     * El resultado se devuelve en formato JSON a través del DTO SegmentoResponse.
     */
    @GetMapping("/segmentos")
    public List<SegmentoResponse> obtenerSegmentosSalariales() {
        return reportService.obtenerSegmentos();
    }

    /**
     * Endpoint correspondiente a la consulta ii -- Parte 2 (MySQL):
     *
     * "Obtener cantidad de empleados por segmento salarial, agrupado por departamento:
     *  - Segmento A: menor a USD 3.500
     *  - Segmento B: entre USD 3.500 y 7.999
     *  - Segmento C: mayor o igual a USD 8.000"
     *
     * La agrupación debe realizarse por nombre de departamento y segmento salarial.
     *
     * El resultado se devuelve en formato JSON a través del DTO SegmentoDepartamentoResponse.
     */
    @GetMapping("/segmentos/departamentos")
    public List<SegmentoDepartamentoResponse> obtenerSegmentosPorDepartamento() {
        return reportService.obtenerSegmentosPorDepartamento();
    }

    /**
     * Endpoint correspondiente a la consulta iii-- de la Parte 2 (MySQL):
     *
     * "Obtener la información del empleado con mayor sueldo por cada departamento."
     *
     * La información a devolver incluye: ID del empleado, nombre, apellido, nombre del departamento y sueldo.
     *
     * El resultado se devuelve en formato JSON a través del DTO EmpleadoMayorSueldoResponse.
     */
    @GetMapping("/mayor-sueldo")
    public List<EmpleadoMayorSueldoResponse> obtenerEmpleadosConMayorSueldoPorDepartamento() {
        return reportService.obtenerEmpleadosConMayorSueldoPorDepartamento();
    }

    /**
     * Endpoint correspondiente a la consulta iv-- de la Parte 2 (MySQL):
     *
     * "Obtener la información de los gerentes contratados hace más de 15 años.
     *  Se consideró como 'gerentes' a todos los empleados cuyo EMPLOYEE_ID aparece como MANAGER_ID
     *  de otros empleados en la tabla employees (relación autorreferenciada del esquema)."
     *
     * La información a devolver incluye: ID del empleado, nombre, apellido, job ID, sueldo y fecha de contratación.
     *
     * El resultado se devuelve en formato JSON a través del DTO GerenteAntiguoResponse.
     */
    @GetMapping("/gerentes-antiguos")
    public List<GerenteAntiguoResponse> obtenerGerentesAntiguos() {
        return reportService.obtenerGerentesAntiguos();
    }

    /**
     * Endpoint correspondiente a la consulta v-- de la Parte 2 (MySQL):
     *
     * "Obtener el salario promedio de los departamentos que tienen más de 10 empleados."
     *
     * La información a devolver incluye: nombre del departamento, salario promedio y cantidad de empleados.
     *
     * El resultado se devuelve en formato JSON a través del DTO SalarioPromedioDepartamentoResponse.
     */
    @GetMapping("/departamentos/salario-promedio")
    public List<SalarioPromedioDepartamentoResponse> obtenerSalarioPromedioPorDepartamento() {
        return reportService.obtenerSalarioPromedioPorDepartamento();
    }

    /**
     * Endpoint correspondiente a la consulta vi-- de la Parte 2 (MySQL):
     *
     * "Obtener la información agrupada por país:
     *  - Cantidad de empleados
     *  - Salario promedio
     *  - Salario más alto
     *  - Salario más bajo
     *  - Promedio de años de antigüedad"
     *
     * La información a devolver incluye el nombre del país, junto con los indicadores mencionados.
     *
     * El resultado se devuelve en formato JSON a través del DTO EstadisticasPaisResponse.
     */
    @GetMapping("/paises/estadisticas-empleados")
    public List<EstadisticasPaisResponse> obtenerEstadisticasPorPais() {
        return reportService.obtenerEstadisticasPorPais();
    }

}
