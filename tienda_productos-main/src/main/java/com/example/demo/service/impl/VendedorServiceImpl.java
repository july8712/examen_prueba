package com.example.demo.service.impl;

import com.example.demo.dto.VendedorDTO;
import com.example.demo.entity.VendedorEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.VendedorMapper;
import com.example.demo.repository.VendedorRepository;
import com.example.demo.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorServiceImpl implements VendedorService {

    private final VendedorMapper vendedorMapper;
    private final VendedorRepository vendedorRepository;

    @Autowired
    public VendedorServiceImpl(VendedorMapper vendedorMapper,
                               VendedorRepository vendedorRepository){
        this.vendedorMapper = vendedorMapper;
        this.vendedorRepository = vendedorRepository;
    }
    @Override
    public VendedorDTO crearVendedor(VendedorDTO vendedorDTO) {
        VendedorEntity vendedorEntity = vendedorMapper.toEntity(vendedorDTO);
        VendedorEntity vendedorGuardado = vendedorRepository.save(vendedorEntity);
        VendedorDTO vendedorARetornar = vendedorMapper.toDTO(vendedorGuardado);

        return vendedorARetornar;
    }

    @Override
    public List<VendedorDTO> obtenerVendedores() throws ResourceNotFoundException {
        List<VendedorEntity> listaVendedores = vendedorRepository.findAll();
        if(listaVendedores.isEmpty()){
            throw new ResourceNotFoundException("Lista vacia");
        }

        List<VendedorDTO> listaVendedoresARetornar = vendedorMapper.toListDTO(listaVendedores);

        return listaVendedoresARetornar;
    }

    @Override
    public VendedorDTO actualizarVendedor(Long id, VendedorDTO vendedorDTO) throws ResourceNotFoundException {
        VendedorEntity vendedorEntity = vendedorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No existe el id: " + id)
        );
        VendedorEntity vendedorActualizado = vendedorMapper.toSet(vendedorEntity, vendedorDTO);
        VendedorEntity vendedor = vendedorRepository.save(vendedorActualizado);
        VendedorDTO vendedorDTO1 = vendedorMapper.toDTO(vendedor);

        return vendedorDTO1;
    }

    @Override
    public void eliminarVendedor(Long id) throws ResourceNotFoundException {
        vendedorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No existe el id: " + id)
        );
        vendedorRepository.deleteById(id);
    }
}
