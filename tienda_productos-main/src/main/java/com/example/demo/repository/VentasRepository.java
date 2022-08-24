package com.example.demo.repository;

import com.example.demo.entity.VentasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<VentasEntity, Long> {
}
