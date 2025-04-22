package com.paula.empleadosreportesapi.repository;

import com.paula.empleadosreportesapi.dto.SegmentoResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportRepository {

    public List<SegmentoResponse> obtenerSegmentos() {
        // Aquí iría la consulta real a la base de datos usando @Query
        // Revisar sql/consultas.sql i para ver la consulta completa
    }

    public List<SegmentoDepartamentoResponse> obtenerSegmentosPorDepartamento() {
        // Aquí iría la consulta real a la base de datos usando @Query
        // Revisar sql/consultas.sql ii para ver la consulta completa
    }

    public List<EmpleadoMayorSueldoResponse> obtenerEmpleadosConMayorSueldoPorDepartamento() {
        // Aquí iría la consulta real a la base de datos usando @Query
        // Revisar sql/consultas.sql iii para ver la consulta completa
    }

    public List<GerenteAntiguoResponse> obtenerGerentesAntiguos() {
        // Aquí iría la consulta real a la base de datos usando @Query
        // Revisar sql/consultas.sql iv para ver la consulta completa
    }

    public List<SalarioPromedioDepartamentoResponse> obtenerSalarioPromedioPorDepartamento() {
        // Aquí iría la consulta real a la base de datos usando @Query
        // Revisar sql/consultas.sql v para ver la consulta completa
    }

    public List<EstadisticasPaisResponse> obtenerEstadisticasPorPais() {
        // Aquí iría la consulta real a la base de datos usando @Query
        // Revisar sql/consultas.sql vi para ver la consulta completa
    }

}
