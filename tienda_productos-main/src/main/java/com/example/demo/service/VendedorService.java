package com.example.demo.service;

import com.example.demo.dto.VendedorDTO;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface VendedorService {

    VendedorDTO crearVendedor (VendedorDTO vendedorDTO);

    List<VendedorDTO> obtenerVendedores () throws ResourceNotFoundException;

    VendedorDTO actualizarVendedor(Long id, VendedorDTO vendedorDTO) throws ResourceNotFoundException;

    void eliminarVendedor(Long id) throws ResourceNotFoundException;
}
