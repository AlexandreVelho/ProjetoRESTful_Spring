package com.lucasangelo.todosimple.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Fleet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Adicione esta linha

    @OneToMany
    private List<Truck> trucks;

    @OneToMany
    private List<Driver> drivers;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {  // Adicione este método
        return name;
    }

    public void setName(String name) {  // Adicione este método
        this.name = name;
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
