package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@Entity
public class VentasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ventas_productos",
            joinColumns = @JoinColumn(name = "ventas_id"),
            inverseJoinColumns = @JoinColumn(name = "productos_id"))
    private Set<ProductoEntity> producto = new HashSet<>();

    public void agregarProductos(ProductoEntity productoEntity){
        producto.add(productoEntity);
        productoEntity.getVentas().add(this);
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,
    CascadeType.MERGE})
    @JoinColumn(name = "codigo", insertable = false, updatable = false)
    private VendedorEntity vendedor;

    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Override
    public String toString() {
        return "VentasEntity{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentasEntity ventas = (VentasEntity) o;
        return Objects.equals(id, ventas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
