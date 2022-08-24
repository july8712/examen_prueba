package com.example.demo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class VentasDTO {

    private Long codigo;

    private VendedorDTO vendedorDTO;

    private Set<ProductoDTO> producto;
}
