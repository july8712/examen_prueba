package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class VendedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nombre;
    private double sueldo;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    private List<VentasEntity> ventasEntities = new ArrayList<>();

    @Override
    public String toString() {
        return "VendedorEntity{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
