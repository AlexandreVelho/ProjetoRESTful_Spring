package com.lucasangelo.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucasangelo.todosimple.models.Fleet;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, Long> {
    
    // Método para buscar uma frota pelo ID do motorista
    Fleet findByDrivers_Id(Long driverId);
}
