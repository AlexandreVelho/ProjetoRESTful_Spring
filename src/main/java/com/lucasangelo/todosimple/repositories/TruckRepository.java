package com.lucasangelo.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucasangelo.todosimple.models.Truck;
import java.util.List;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {
    // Busca por placa
    Truck findByLicensePlate(String licensePlate);

    // Busca por modelo
    List<Truck> findByModel(String model);
}
