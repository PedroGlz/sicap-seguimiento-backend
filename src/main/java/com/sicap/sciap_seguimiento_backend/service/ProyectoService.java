package com.sicap.sciap_seguimiento_backend.service;

import com.sicap.sciap_seguimiento_backend.entity.Proyecto;
import com.sicap.sciap_seguimiento_backend.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public Proyecto crearProyecto(Proyecto proyecto, Long usuarioId) {
        Integer maxOrden = proyectoRepository.findMaxOrden();
        proyecto.setOrden((maxOrden != null ? maxOrden : 0) + 1);
        proyecto.setUsuarioCreador(usuarioId);
        proyecto.setActivo("1");
        LocalDateTime ahora = LocalDateTime.now();
        proyecto.setFechaCreacion(ahora);

        return proyectoRepository.save(proyecto);
    }

    public List<Proyecto> obtenerTodos() {
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> obtenerPorId(Integer id) {
        return proyectoRepository.findById(id);
    }

    public Proyecto guardar(Proyecto proyecto) {
        LocalDateTime ahora = LocalDateTime.now();
        proyecto.setFechaModificacion(ahora);

        return proyectoRepository.save(proyecto);
    }

    public void eliminar(Integer id) {
        proyectoRepository.deleteById(id);
    }
}