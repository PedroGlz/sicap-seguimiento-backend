package com.sicap.sciap_seguimiento_backend.repository;

import com.sicap.sciap_seguimiento_backend.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    @Query("SELECT COALESCE(MAX(p.orden), 0) FROM Proyecto p")
    Integer findMaxOrden();
}