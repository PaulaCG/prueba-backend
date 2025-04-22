package com.paula.vehiculos.controller;

import com.paula.vehiculos.model.Vehiculo;
import com.paula.vehiculos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController extends BaseCrudController<Vehiculo, Long> {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    protected JpaRepository<Vehiculo, Long> getRepository() {
        return vehiculoRepository;
    }
}
