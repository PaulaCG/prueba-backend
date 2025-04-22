package com.paula.empleadosreportesapi.service;

import com.paula.empleadosreportesapi.dto.SegmentoResponse;
import com.paula.empleadosreportesapi.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<SegmentoResponse> obtenerSegmentos() {
        return reportRepository.obtenerSegmentos();
    }

    public List<SegmentoDepartamentoResponse> obtenerSegmentosPorDepartamento() {
        return reportRepository.obtenerSegmentosPorDepartamento();
    }

    public List<EmpleadoMayorSueldoResponse> obtenerEmpleadosConMayorSueldoPorDepartamento() {
        return reportRepository.obtenerEmpleadosConMayorSueldoPorDepartamento();
    }

    public List<GerenteAntiguoResponse> obtenerGerentesAntiguos() {
        return reportRepository.obtenerGerentesAntiguos();
    }

    public List<SalarioPromedioDepartamentoResponse> obtenerSalarioPromedioPorDepartamento() {
        return reportRepository.obtenerSalarioPromedioPorDepartamento();
    }

    public List<EstadisticasPaisResponse> obtenerEstadisticasPorPais() {
        return reportRepository.obtenerEstadisticasPorPais();
    }

}
