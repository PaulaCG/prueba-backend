package com.paula.vehiculos.controller;

import com.paula.vehiculos.exception.ResourceNotFoundException;
import com.paula.vehiculos.model.Camion;
import com.paula.vehiculos.repository.CamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/camiones")
public class CamionController extends BaseCrudController<Camion, Long> {

    @Autowired
    private CamionRepository camionRepository;

    @Override
    protected JpaRepository<Camion, Long> getRepository() {
        return camionRepository;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Camion> getById(@PathVariable Long id) {
        return camionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Camión no encontrado con ID: " + id));
    }
}
