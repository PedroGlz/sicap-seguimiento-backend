package com.sicap.sciap_seguimiento_backend.service;

import com.sicap.sciap_seguimiento_backend.entity.Actividad;
import com.sicap.sciap_seguimiento_backend.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {
    @Autowired
    private ActividadRepository actividadRepository;

    public List<Actividad> findAll() {
        return actividadRepository.findAll();
    }

    public Optional<Actividad> findById(Integer id) {
        return actividadRepository.findById(id);
    }

    public List<Actividad> findByGrupoId(Integer idGrupo) {
        return actividadRepository.findByGrupo_IdGrupo(idGrupo);
    }

    public Actividad save(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public void deleteById(Integer id) {
        actividadRepository.deleteById(id);
    }
}
