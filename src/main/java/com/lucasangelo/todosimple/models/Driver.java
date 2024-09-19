package com.lucasangelo.todosimple.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = Driver.TABLE_NAME)
public class Driver {
    public static final String TABLE_NAME = "driver";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 100)
    private String name;

    @Column(name = "license", length = 20, nullable = false)
    @NotNull
    @NotEmpty
    private String license; // Número da carteira de motorista

    @Column(name = "status", length = 20, nullable = false)
    @NotNull
    @NotEmpty
    private String status; // Status do motorista, como "Disponível", "Em Viagem", etc.

    public Driver() {
    }

    public Driver(Long id, String name, String license, String status) {
        this.id = id;
        this.name = name;
        this.license = license;
        this.status = status;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
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
        Driver other = (Driver) obj;
        return Objects.equals(id, other.id) && Objects.equals(license, other.license);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, license);
    }
}
