package com.example.demo.service.impl;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.entity.ProductoEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.ProductoMapper;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoMapper productoMapper,
                                ProductoRepository productoRepository){
        this.productoMapper = productoMapper;
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        ProductoEntity productoEntity = productoMapper.toEntity(productoDTO);
        ProductoEntity productoGuardado = productoRepository.save(productoEntity);
        ProductoDTO productoARetornar = productoMapper.toDTO(productoGuardado);

        return productoARetornar;
    }

    @Override
    public List<ProductoDTO> obtenerProducto() throws ResourceNotFoundException {
        List<ProductoEntity> listaProductos = productoRepository.findAll();

        if(listaProductos.isEmpty()){
            throw new ResourceNotFoundException("Lista vacia");
        }

        List<ProductoDTO> listaProductosARetornar = productoMapper.toListDTO(listaProductos);

        return listaProductosARetornar;
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) throws ResourceNotFoundException {
        ProductoEntity productoEntity = productoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No existe el id: " + id)
        );
        ProductoEntity productoActualizado = productoMapper.toSet(productoEntity, productoDTO);
        ProductoEntity producto= productoRepository.save(productoActualizado);
        ProductoDTO productoDTO1 = productoMapper.toDTO(producto);

        return productoDTO1;
    }

    @Override
    public void eliminarProducto(Long id) throws ResourceNotFoundException {
        productoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No existe el id: " + id)
        );
        productoRepository.deleteById(id);
    }
}
