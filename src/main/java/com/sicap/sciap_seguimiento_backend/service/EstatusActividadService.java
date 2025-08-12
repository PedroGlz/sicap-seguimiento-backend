package com.sicap.sciap_seguimiento_backend.service;

import com.sicap.sciap_seguimiento_backend.entity.EstatusActividad;
import com.sicap.sciap_seguimiento_backend.repository.EstatusActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstatusActividadService {
    @Autowired
    private EstatusActividadRepository estatusActividadRepository;

    public List<EstatusActividad> findAll() {
        return estatusActividadRepository.findAll();
    }

    public Optional<EstatusActividad> findById(Integer id) {
        return estatusActividadRepository.findById(id);
    }

    public EstatusActividad save(EstatusActividad estatusActividad) {
        return estatusActividadRepository.save(estatusActividad);
    }

    public void deleteById(Integer id) {
        estatusActividadRepository.deleteById(id);
    }
}
