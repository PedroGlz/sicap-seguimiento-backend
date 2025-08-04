package com.sicap.sciap_seguimiento_backend.repository;

import com.sicap.sciap_seguimiento_backend.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    List<Grupo> findByProyecto_IdProyecto(Integer idProyecto);
}