package com.paula.vehiculos.controller;

import com.paula.vehiculos.exception.ResourceNotFoundException;
import com.paula.vehiculos.model.Automovil;
import com.paula.vehiculos.repository.AutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/automoviles")
public class AutomovilController extends BaseCrudController<Automovil, Long> {

    @Autowired
    private AutomovilRepository automovilRepository;

    @Override
    protected JpaRepository<Automovil, Long> getRepository() {
        return automovilRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Automovil> getById(@PathVariable Long id) {
        return automovilRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Automóvil no encontrado"));
    }

}
