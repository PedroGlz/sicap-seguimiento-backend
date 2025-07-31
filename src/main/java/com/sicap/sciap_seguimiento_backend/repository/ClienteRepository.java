package com.sicap.sciap_seguimiento_backend.repository;

import com.sicap.sciap_seguimiento_backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}