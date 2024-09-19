package com.lucasangelo.todosimple.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import com.lucasangelo.todosimple.models.Driver;
import com.lucasangelo.todosimple.repositories.DriverRepository;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver findById(Long id) {
        Optional<Driver> driver = this.driverRepository.findById(id);
        return driver.orElseThrow(() -> new RuntimeException(
                "Motorista não encontrado! Id: " + id + ", Tipo: " + Driver.class.getName()));
    }

    @Transactional
    public Driver create(Driver obj) {
        obj.setId(null); // Setar o id como null para criar um novo motorista
        obj = this.driverRepository.save(obj);
        return obj;
    }

    @Transactional
    public Driver update(Driver obj) {
        Driver existingDriver = findById(obj.getId());
        // Atualiza os campos que podem ser modificados
        existingDriver.setName(obj.getName());
        existingDriver.setLicense(obj.getLicense());
        existingDriver.setStatus(obj.getStatus());
        return this.driverRepository.save(existingDriver);
    }

    public void delete(Long id) {
        findById(id); // Verifica se o motorista existe antes de deletar
        try {
            this.driverRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
