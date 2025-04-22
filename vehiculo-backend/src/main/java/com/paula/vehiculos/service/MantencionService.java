package com.paula.vehiculos.service;

import com.paula.vehiculos.dto.MantencionDTO;
import com.paula.vehiculos.model.Mantencion;
import com.paula.vehiculos.model.Vehiculo;
import com.paula.vehiculos.repository.MantencionRepository;
import com.paula.vehiculos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MantencionService {

    @Autowired
    private MantencionRepository mantencionRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Mantencion> getByVehiculoId(Long vehiculoId) {
        return mantencionRepository.findByVehiculoId(vehiculoId);
    }

    public Mantencion save(Mantencion mantencion) {
        Long vehiculoId = mantencion.getVehiculo().getId();
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + vehiculoId));
        mantencion.setVehiculo(vehiculo);
        return mantencionRepository.save(mantencion);
    }

    public void delete(Long id) {
        mantencionRepository.deleteById(id);
    }

    public Mantencion saveFromDto(MantencionDTO dto) {
        Vehiculo vehiculo = vehiculoRepository.findById(dto.vehiculoId)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

        Mantencion mantencion = new Mantencion();
        mantencion.setFecha(dto.fecha);
        mantencion.setDescripcion(dto.descripcion);
        mantencion.setCosto(dto.costo);
        mantencion.setVehiculo(vehiculo);

        return mantencionRepository.save(mantencion);
    }
}
