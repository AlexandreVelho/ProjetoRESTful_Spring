package com.lucasangelo.todosimple.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import com.lucasangelo.todosimple.models.Truck;
import com.lucasangelo.todosimple.repositories.TruckRepository;

@Service
public class TruckService {

    @Autowired
    private TruckRepository truckRepository;

    public Truck findById(Long id) {
        Optional<Truck> truck = this.truckRepository.findById(id);
        return truck.orElseThrow(() -> new RuntimeException(
                "Caminhão não encontrado! Id: " + id + ", Tipo: " + Truck.class.getName()));
    }

    @Transactional
    public Truck create(Truck obj) {
        obj.setId(null); // Setar o id como null para criar um novo caminhão
        obj = this.truckRepository.save(obj);
        return obj;
    }

    @Transactional
    public Truck update(Truck obj) {
        Truck existingTruck = findById(obj.getId());
        // Atualiza os campos que podem ser modificados
        existingTruck.setLicensePlate(obj.getLicensePlate());
        existingTruck.setModel(obj.getModel());
        existingTruck.setYear(obj.getYear());
        existingTruck.setCapacity(obj.getCapacity());
        existingTruck.setStatus(obj.getStatus());
        return this.truckRepository.save(existingTruck);
    }

    public void delete(Long id) {
        findById(id); // Verifica se o caminhão existe antes de deletar
        try {
            this.truckRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
