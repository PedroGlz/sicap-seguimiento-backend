package com.sicap.sciap_seguimiento_backend.service;

import com.sicap.sciap_seguimiento_backend.entity.Proyecto;
import com.sicap.sciap_seguimiento_backend.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> obtenerTodos() {
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> obtenerPorId(Integer id) {
        return proyectoRepository.findById(id);
    }

    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public void eliminar(Integer id) {
        proyectoRepository.deleteById(id);
    }
}