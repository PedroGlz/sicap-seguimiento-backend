package com.sicap.sciap_seguimiento_backend.controller;

import com.sicap.sciap_seguimiento_backend.entity.EstatusActividad;
import com.sicap.sciap_seguimiento_backend.service.EstatusActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estatus-actividad")
public class EstatusActividadController {
    @Autowired
    private EstatusActividadService estatusActividadService;

    @GetMapping
    public List<EstatusActividad> getAll() {
        return estatusActividadService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EstatusActividad> getById(@PathVariable Integer id) {
        return estatusActividadService.findById(id);
    }

    @PostMapping
    public EstatusActividad create(@RequestBody EstatusActividad estatusActividad) {
        return estatusActividadService.save(estatusActividad);
    }

    @PutMapping("/{id}")
    public EstatusActividad update(@PathVariable Integer id, @RequestBody EstatusActividad estatusActividad) {
        estatusActividad.setIdEstatusActividad(id);
        return estatusActividadService.save(estatusActividad);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        estatusActividadService.deleteById(id);
    }
}
