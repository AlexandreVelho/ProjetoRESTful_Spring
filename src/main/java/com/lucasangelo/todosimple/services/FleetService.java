package com.lucasangelo.todosimple.services;

import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucasangelo.todosimple.models.Fleet;
import com.lucasangelo.todosimple.models.Truck;
import com.lucasangelo.todosimple.models.Driver;
import com.lucasangelo.todosimple.repositories.FleetRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class FleetService {

    @Autowired
    private FleetRepository fleetRepository;

    // Método para criar uma nova frota
    public Fleet createFleet(Fleet fleet) {
        return fleetRepository.save(fleet);
    }

    // Método para adicionar caminhão a uma frota
    public Fleet addTruckToFleet(Long fleetId, Truck truck) {
        Optional<Fleet> fleetOpt = fleetRepository.findById(fleetId);
        if (fleetOpt.isPresent()) {
            Fleet fleet = fleetOpt.get();
            if (fleet.getTrucks() != null) {
                fleet.getTrucks().add(truck);
            } else {
                fleet.setTrucks(new ArrayList<>());
                fleet.getTrucks().add(truck);
            }
            return fleetRepository.save(fleet);
        }
        return null;
    }

    // Método para adicionar motorista a uma frota
    public Fleet addDriverToFleet(Long fleetId, Driver driver) {
        Optional<Fleet> fleetOpt = fleetRepository.findById(fleetId);
        if (fleetOpt.isPresent()) {
            Fleet fleet = fleetOpt.get();
            if (fleet.getDrivers() != null) {
                fleet.getDrivers().add(driver);
            } else {
                fleet.setDrivers(new ArrayList<>());
                fleet.getDrivers().add(driver);
            }
            return fleetRepository.save(fleet);
        }
        return null;
    }

    // Novo método para buscar frota associada a um motorista específico
    public Fleet findByDriverId(Long driverId) {
        return fleetRepository.findByDrivers_Id(driverId);
    }

    // Método para atualizar uma frota existente
    public Fleet updateFleet(Long fleetId, Fleet updatedFleet) {
        // Verifica se a frota existe
        Fleet existingFleet = fleetRepository.findById(fleetId)
            .orElseThrow(() -> new RuntimeException("Fleet not found"));

        // Atualiza os campos da frota conforme necessário (se não forem nulos)
        if (updatedFleet.getName() != null) {
            existingFleet.setName(updatedFleet.getName());
        }
        if (updatedFleet.getTrucks() != null) {
            existingFleet.setTrucks(updatedFleet.getTrucks());
        }
        if (updatedFleet.getDrivers() != null) {
            existingFleet.setDrivers(updatedFleet.getDrivers());
        }

        // Salva a frota atualizada
        return fleetRepository.save(existingFleet);
    }

    // Método para remover motorista da frota
    public Fleet removeDriverFromFleet(Long fleetId, Long driverId) {
        Fleet fleet = fleetRepository.findById(fleetId)
            .orElseThrow(() -> new RuntimeException("Fleet not found"));

        Iterator<Driver> iterator = fleet.getDrivers().iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            if (driver.getId().equals(driverId)) {
                iterator.remove();
                break;
            }
        }

        return fleetRepository.save(fleet);
    }

    // Método para remover caminhão da frota
    public Fleet removeTruckFromFleet(Long fleetId, Long truckId) {
        Fleet fleet = fleetRepository.findById(fleetId)
            .orElseThrow(() -> new RuntimeException("Fleet not found"));

        Iterator<Truck> iterator = fleet.getTrucks().iterator();
        while (iterator.hasNext()) {
            Truck truck = iterator.next();
            if (truck.getId().equals(truckId)) {
                iterator.remove();
                break;
            }
        }

        return fleetRepository.save(fleet);
    }

     // Método para encontrar caminhões associados a um motorista específico
     public List<Truck> findTrucksByDriverId(Long driverId) {
        List<Fleet> fleets = fleetRepository.findAll(); // Busca todas as frotas
        List<Truck> trucks = new ArrayList<>();

        for (Fleet fleet : fleets) {
            if (fleet.getDrivers() != null) {
                for (Driver driver : fleet.getDrivers()) {
                    if (driver.getId().equals(driverId)) {
                        trucks.addAll(fleet.getTrucks());
                    }
                }
            }
        }
        return trucks;
    }
}