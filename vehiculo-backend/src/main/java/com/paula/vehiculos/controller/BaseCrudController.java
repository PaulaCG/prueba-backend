package com.paula.vehiculos.controller;


import com.paula.vehiculos.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class BaseCrudController<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    @GetMapping
    public List<T> getAll() {
        return getRepository().findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        Optional<T> entity = getRepository().findById(id);
        return entity.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return getRepository().save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        if (!getRepository().existsById(id)) {
            throw new ResourceNotFoundException("Elemento no encontrado con ID: " + id);
        }

        try {
            var method = entity.getClass().getMethod("setId", id.getClass());
            method.invoke(entity, id);
        } catch (Exception e) {
            //
        }

        return ResponseEntity.ok(getRepository().save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (!getRepository().existsById(id)) {
            throw new ResourceNotFoundException("Elemento no encontrado");
        }
        getRepository().deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
