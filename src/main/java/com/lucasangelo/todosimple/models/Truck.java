package com.lucasangelo.todosimple.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = Truck.TABLE_NAME)
public class Truck {
    public static final String TABLE_NAME = "truck";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "license_plate", length = 10, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 10)
    private String licensePlate;

    @Column(name = "model", length = 50, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String model;

    @Column(name = "year", nullable = false)
    @NotNull
    private int year;

    @Column(name = "capacity", nullable = false)
    @NotNull
    private double capacity;

    @Column(name = "status", length = 20, nullable = false)
    @NotNull
    @NotEmpty
    private String status; // Status pode ser algo como "Disponível", "Em Manutenção", etc.

    public Truck() {
    }

    public Truck(Long id, String licensePlate, String model, int year, double capacity, String status) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.model = model;
        this.year = year;
        this.capacity = capacity;
        this.status = status;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Truck other = (Truck) obj;
        return Objects.equals(id, other.id) && Objects.equals(licensePlate, other.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licensePlate);
    }
}
