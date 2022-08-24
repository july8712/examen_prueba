package com.example.demo.repository;

import com.example.demo.entity.VendedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, Long> {
}
