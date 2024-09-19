package com.lucasangelo.todosimple.controllers;

import javax.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucasangelo.todosimple.models.Driver;
import com.lucasangelo.todosimple.services.DriverService;

@RestController
@RequestMapping("/driver")
@Validated
public class DriverController {

    @Autowired
    private DriverService driverService;

    // localhost:8080/driver/id - busca motorista pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Driver> findById(@PathVariable Long id) {
        Driver obj = this.driverService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    // Criação de um novo motorista
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Driver obj) {
        this.driverService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    // Atualização de um motorista existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Driver obj, @PathVariable Long id) {
        obj.setId(id);
        this.driverService.update(obj);
        return ResponseEntity.noContent().build();
    }

    // Deleção de um motorista
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.driverService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
