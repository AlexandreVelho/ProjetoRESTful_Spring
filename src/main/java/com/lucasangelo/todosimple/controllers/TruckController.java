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

import com.lucasangelo.todosimple.models.Truck;
import com.lucasangelo.todosimple.services.TruckService;

@RestController
@RequestMapping("/truck")
@Validated
public class TruckController {

    @Autowired
    private TruckService truckService;

    // localhost:8080/truck/id - busca caminhão pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Truck> findById(@PathVariable Long id) {
        Truck obj = this.truckService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    // Criação de um novo caminhão
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Truck obj) {
        this.truckService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    // Atualização de um caminhão existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Truck obj, @PathVariable Long id) {
        obj.setId(id);
        this.truckService.update(obj);
        return ResponseEntity.noContent().build();
    }

    // Deleção de um caminhão
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.truckService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
