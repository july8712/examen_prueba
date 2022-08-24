package com.example.demo.mapper;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.dto.VendedorDTO;
import com.example.demo.dto.VentasDTO;
import com.example.demo.entity.ProductoEntity;
import com.example.demo.entity.VentasEntity;
import com.example.demo.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class VentasMapper {

    @Autowired
    private ProductoMapper productoMapper;
    @Autowired
    private VendedorMapper vendedorMapper;
    @Autowired
    private VendedorRepository vendedorRepository;

    public VentasEntity toEntity(VentasDTO ventasDTO){
        VentasEntity ventas = new VentasEntity();
        ventas.setCodigo(ventasDTO.getCodigo());
        return ventas;
    }
    //------------------------------------------------------------------
    public VentasDTO toDTO(VentasEntity ventasEntity){
        VentasDTO ventasDTO = new VentasDTO();
        ventasDTO.setCodigo(ventasEntity.getId());
        ventasDTO.setVendedorDTO(getVendedor(ventasEntity));
        ventasDTO.setProducto(getProductos(ventasEntity));

        return ventasDTO;
    }

    public VendedorDTO getVendedor(VentasEntity ventasEntity){
        VendedorDTO vendedorDTO = vendedorMapper.toDTO(ventasEntity.getVendedor());
        double comision = 0;
        if(ventasEntity.getProducto().size() > 2){
            comision = ventasEntity.getVendedor().getSueldo() * 0.10;
        }else if(ventasEntity.getProducto().size() > 0 && ventasEntity.getProducto().size() <= 2){
            comision = ventasEntity.getVendedor().getSueldo() * 0.05;
        }
        vendedorDTO.setComision(comision);
        vendedorDTO.setSueldoTotal( ventasEntity.getVendedor().getSueldo() + comision);
        return vendedorDTO;
    }

    public Set<ProductoDTO> getProductos(VentasEntity ventasEntity){
        return productoMapper.setProductoDTO(ventasEntity.getProducto());
    }

    //---------------------------------------------------------------------
    public List<VentasDTO> toListDTO(List<VentasEntity> list){
        List<VentasDTO> lista = new ArrayList<>();

        for (VentasEntity ventasEntity : list) {
            lista.add(toDTO(ventasEntity));
        }

        return lista;
    }

    public VentasDTO obtenerVentaDTO(VentasEntity ventasEntity){
        VentasDTO ventasDTO = toDTO(ventasEntity);
        ventasDTO.setProducto(setProductoDTO(ventasEntity.getProducto()));
        return  ventasDTO;
    }

    public Set<ProductoDTO> setProductoDTO(Set<ProductoEntity> productoEntitySet){
        return productoMapper.setProductoDTO(productoEntitySet);
    }
}
