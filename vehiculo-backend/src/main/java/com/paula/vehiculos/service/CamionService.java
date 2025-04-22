package com.paula.vehiculos.service;

import com.paula.vehiculos.model.Camion;
import com.paula.vehiculos.repository.CamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamionService {

    @Autowired
    private CamionRepository camionRepository;

    public List<Camion> getAll() {
        return camionRepository.findAll();
    }

    public Optional<Camion> getById(Long id) {
        return camionRepository.findById(id);
    }

    public Camion save(Camion camion) {
        return camionRepository.save(camion);
    }

    public void delete(Long id) {
        camionRepository.deleteById(id);
    }
}
