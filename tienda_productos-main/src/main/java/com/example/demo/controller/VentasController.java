package com.example.demo.controller;


import com.example.demo.dto.VentasDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "http://localhost:4200")
public class VentasController {


    @Autowired
    private VentasService ventasService;

    @PostMapping
    public ResponseEntity<?> crearVenta(@RequestBody VentasDTO ventasDTO){
        ventasService.crearVentas(ventasDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> obtenerVentas() throws ResourceNotFoundException {
        return new ResponseEntity<>(ventasService.obtenerVentas(), HttpStatus.OK);
    }

    @PostMapping("/{id}/producto")
    public ResponseEntity<?> agregarProductoAVentas(@PathVariable Long id, @RequestBody List<Long> productosId) throws ResourceNotFoundException {
        return new ResponseEntity<>(ventasService.agregarProductoAVenta(id, productosId), HttpStatus.CREATED);
    }



}
