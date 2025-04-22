package com.paula.vehiculos.service;

import com.paula.vehiculos.model.Automovil;
import com.paula.vehiculos.repository.AutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutomovilService {

    @Autowired
    private AutomovilRepository automovilRepository;

    public List<Automovil> getAll() {
        return automovilRepository.findAll();
    }

    public Optional<Automovil> getById(Long id) {
        return automovilRepository.findById(id);
    }

    public Automovil save(Automovil automovil) {
        return automovilRepository.save(automovil);
    }

    public void delete(Long id) {
        automovilRepository.deleteById(id);
    }
}
