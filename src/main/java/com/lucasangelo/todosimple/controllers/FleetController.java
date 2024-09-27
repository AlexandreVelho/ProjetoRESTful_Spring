package com.lucasangelo.todosimple.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import com.lucasangelo.todosimple.models.Fleet;
import com.lucasangelo.todosimple.models.Truck;
import com.lucasangelo.todosimple.models.Driver;
import com.lucasangelo.todosimple.services.FleetService;
import com.lucasangelo.todosimple.repositories.DriverRepository;
import com.lucasangelo.todosimple.repositories.TruckRepository;


@RestController
@RequestMapping("/fleet")
public class FleetController {

    @Autowired
    private FleetService fleetService;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TruckRepository truckRepository;

    @PostMapping("/create")
    public Fleet createFleet(@RequestBody Fleet fleet) {
        return fleetService.createFleet(fleet);
    }

   // Renomeado para evitar duplicação
   @GetMapping("/fleet-by-driver/{driverId}")
   public Fleet getFleetByDriver(@PathVariable Long driverId) {
       return fleetService.findByDriverId(driverId);  
   }

    @PostMapping("/{fleetId}/add-driver")
    public Fleet addDriverToFleet(@PathVariable Long fleetId, @RequestBody Long driverId) {
        Driver driver = driverRepository.findById(driverId)
            .orElseThrow(() -> new RuntimeException("Driver not found"));
        return fleetService.addDriverToFleet(fleetId, driver);
    }

    @PostMapping("/{fleetId}/add-truck")
    public Fleet addTruckToFleet(@PathVariable Long fleetId, @RequestBody Long truckId) {
        Truck truck = truckRepository.findById(truckId)
            .orElseThrow(() -> new RuntimeException("Truck not found"));
        return fleetService.addTruckToFleet(fleetId, truck);
    }

    @PutMapping("/update/{fleetId}")
    public Fleet updateFleet(@PathVariable Long fleetId, @RequestBody Fleet updatedFleet) {
        return fleetService.updateFleet(fleetId, updatedFleet);
    }

    // Método para deletar um motorista da frota
    @DeleteMapping("/{fleetId}/remove-driver/{driverId}")
    public Fleet removeDriverFromFleet(@PathVariable Long fleetId, @PathVariable Long driverId) {
        return fleetService.removeDriverFromFleet(fleetId, driverId);
    }

    // Método para deletar um caminhão da frota
    @DeleteMapping("/{fleetId}/remove-truck/{truckId}")
    public Fleet removeTruckFromFleet(@PathVariable Long fleetId, @PathVariable Long truckId) {
        return fleetService.removeTruckFromFleet(fleetId, truckId);
    }

    @GetMapping("/trucks-by-driver/{driverId}")
public List<Truck> getTrucksByDriver(@PathVariable Long driverId) {
    return fleetService.findTrucksByDriverId(driverId);
}

}
