package com.lucasangelo.todosimple.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucasangelo.todosimple.models.Fleet;
import com.lucasangelo.todosimple.models.Truck;
import com.lucasangelo.todosimple.models.Driver;
import com.lucasangelo.todosimple.repositories.FleetRepository;
import java.util.Optional;

@Service
public class FleetService {

    @Autowired
    private FleetRepository fleetRepository;

    // Método para adicionar caminhão a uma frota
    public Fleet addTruckToFleet(Long fleetId, Truck truck) {
        Optional<Fleet> fleetOpt = fleetRepository.findById(fleetId);
        if (fleetOpt.isPresent()) {
            Fleet fleet = fleetOpt.get();
            fleet.getTrucks().add(truck);
            return fleetRepository.save(fleet);
        }
        return null;
    }

    // Método para adicionar motorista a uma frota
    public Fleet addDriverToFleet(Long fleetId, Driver driver) {
        Optional<Fleet> fleetOpt = fleetRepository.findById(fleetId);
        if (fleetOpt.isPresent()) {
            Fleet fleet = fleetOpt.get();
            fleet.getDrivers().add(driver);
            return fleetRepository.save(fleet);
        }
        return null;
    }

    // Novo método para buscar frota associada a um motorista específico
    public Fleet findByDriverId(Long driverId) {
        return fleetRepository.findByDrivers_Id(driverId);
    }
}
