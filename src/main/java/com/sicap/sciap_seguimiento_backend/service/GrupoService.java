package com.sicap.sciap_seguimiento_backend.service;

import com.sicap.sciap_seguimiento_backend.entity.Grupo;
import com.sicap.sciap_seguimiento_backend.repository.GrupoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {
    private final GrupoRepository grupoRepository;

    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    public List<Grupo> findByIdProyecto(Integer idProyecto) {
        return grupoRepository.findByProyecto_IdProyecto(idProyecto);
    }

    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    public Optional<Grupo> findById(Integer id) {
        return grupoRepository.findById(id);
    }

    public Grupo save(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public void deleteById(Integer id) {
        grupoRepository.deleteById(id);
    }

    public void actualizarEstatusColapso(Integer idGrupo, String estatusColapso) {
        System.out.println("Servicio - idGrupo: " + idGrupo + ", estatusColapso: " + estatusColapso);
        Grupo grupo = grupoRepository.findById(idGrupo)
                .orElseThrow(() -> new EntityNotFoundException("Grupo no encontrado"));
        System.out.println("Servicio - Grupo antes: " + grupo.getEstatusColapso());
        if (estatusColapso != null) {
            grupo.setEstatusColapso(estatusColapso);
        }
        System.out.println("Servicio - Grupo después: " + grupo.getEstatusColapso());
        grupoRepository.save(grupo);
    }
}