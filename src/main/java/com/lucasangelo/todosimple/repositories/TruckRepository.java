package com.lucasangelo.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasangelo.todosimple.models.Truck;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {
    // Aqui você pode adicionar consultas específicas, como busca por placa, se necessário
    Truck findByLicensePlate(String licensePlate);
}
