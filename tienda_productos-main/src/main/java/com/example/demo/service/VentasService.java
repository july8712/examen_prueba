package com.example.demo.service;


import com.example.demo.dto.VentasDTO;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface VentasService {

        void crearVentas(VentasDTO ventasDTO);

        List<VentasDTO> obtenerVentas() throws ResourceNotFoundException;

        VentasDTO agregarProductoAVenta(Long id, List<Long> productosId) throws ResourceNotFoundException;
}


