package com.lucasangelo.todosimple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lucasangelo.todosimple.models.Fleet;
import com.lucasangelo.todosimple.models.Truck;  // Certifique-se de que a classe Truck existe e está importada
import com.lucasangelo.todosimple.models.Driver; // Certifique-se de que a classe Driver existe e está importada
import com.lucasangelo.todosimple.services.FleetService;

@RestController
@RequestMapping("/fleet")
public class FleetController {

    @Autowired
    private FleetService fleetService;

    // Endpoint para buscar caminhões associados a um motorista específico
    @GetMapping("/trucks-by-driver/{driverId}")
    public Fleet getTrucksByDriver(@PathVariable Long driverId) {
        return fleetService.findByDriverId(driverId);  
    }

    // Endpoint para adicionar um caminhão à frota
    @PostMapping("/{fleetId}/add-truck")
    public Fleet addTruckToFleet(@PathVariable Long fleetId, @RequestBody Truck truck) {
        return fleetService.addTruckToFleet(fleetId, truck);  // Verifique se o método está implementado no FleetService
    }

    // Endpoint para adicionar um motorista à frota
    @PostMapping("/{fleetId}/add-driver")
    public Fleet addDriverToFleet(@PathVariable Long fleetId, @RequestBody Driver driver) {
        return fleetService.addDriverToFleet(fleetId, driver);  // Verifique se o método está implementado no FleetService
    }
}
