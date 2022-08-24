package com.example.demo.service;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface ProductoService {

    ProductoDTO crearProducto (ProductoDTO productoDTO);

    List<ProductoDTO> obtenerProducto () throws ResourceNotFoundException;

    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) throws ResourceNotFoundException;

    void eliminarProducto(Long id) throws ResourceNotFoundException;
}
