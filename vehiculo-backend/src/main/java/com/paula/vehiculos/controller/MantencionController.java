package com.paula.vehiculos.controller;

import com.paula.vehiculos.dto.MantencionDTO;
import com.paula.vehiculos.model.Mantencion;
import com.paula.vehiculos.service.MantencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mantenciones")
public class MantencionController {

    @Autowired
    private MantencionService mantencionService;

    @GetMapping("/vehiculo/{vehiculoId}")
    public List<Mantencion> getByVehiculo(@PathVariable Long vehiculoId) {
        return mantencionService.getByVehiculoId(vehiculoId);
    }

    @PostMapping
    public Mantencion create(@RequestBody MantencionDTO dto) {
        return mantencionService.saveFromDto(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mantencionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
