package com.lucasangelo.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasangelo.todosimple.models.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    // Aqui você pode adicionar consultas específicas, como busca por nome ou status do motorista
    Driver findByLicense(String license);
}
