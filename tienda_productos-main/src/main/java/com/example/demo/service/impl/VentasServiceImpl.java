package com.example.demo.service.impl;

import com.example.demo.dto.VentasDTO;
import com.example.demo.entity.ProductoEntity;
import com.example.demo.entity.VentasEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.VentasMapper;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.VentasRepository;
import com.example.demo.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentasServiceImpl implements VentasService {
    private final VentasMapper ventasMapper;
    private final VentasRepository ventasRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public VentasServiceImpl(VentasMapper ventasMapper,
                             VentasRepository ventasRepository,
                             ProductoRepository productoRepository) {
        this.ventasMapper = ventasMapper;
        this.ventasRepository = ventasRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public void crearVentas(VentasDTO ventasDTO) {
        VentasEntity ventasEntity = ventasMapper.toEntity(ventasDTO);
        VentasEntity ventasGuardado = ventasRepository.save(ventasEntity);
    }

    @Override
    public List<VentasDTO> obtenerVentas() throws ResourceNotFoundException {
        List<VentasEntity> listaVentas = ventasRepository.findAll();
        if (listaVentas.isEmpty()) {
            throw new ResourceNotFoundException("Lista vacia");
        }

        List<VentasDTO> listaVentasARetornar = ventasMapper.toListDTO(listaVentas);

        return listaVentasARetornar;
    }

    @Override
    public VentasDTO agregarProductoAVenta(Long idVentas, List<Long> productosId) throws ResourceNotFoundException {
        VentasEntity ventas = ventasRepository.findById(idVentas)
                .orElseThrow(() -> new ResourceNotFoundException("Not found id: " + idVentas));

        List<ProductoEntity> producto = new ArrayList<>();
        for (Long id : productosId) {
            producto.add(productoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found id: " + id)));
        }
        producto.forEach(ventas::agregarProductos);
        ventasRepository.save(ventas);

        return ventasMapper.obtenerVentaDTO(ventas);
    }


}
