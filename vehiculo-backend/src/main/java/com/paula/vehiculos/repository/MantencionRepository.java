package com.paula.vehiculos.repository;

import com.paula.vehiculos.model.Mantencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MantencionRepository extends JpaRepository<Mantencion, Long> {
    List<Mantencion> findByVehiculoId(Long vehiculoId);
}
