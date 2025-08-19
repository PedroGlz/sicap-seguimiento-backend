package com.sicap.sciap_seguimiento_backend.controller;

import com.sicap.sciap_seguimiento_backend.dto.ActividadDTO;
import com.sicap.sciap_seguimiento_backend.entity.Actividad;
import com.sicap.sciap_seguimiento_backend.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {
    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public List<Actividad> getAll() {
        return actividadService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Actividad> getById(@PathVariable Integer id) {
        return actividadService.findById(id);
    }

    @GetMapping("/{idGrupo}/actividades")
    public ResponseEntity<List<ActividadDTO>> getActividades(@PathVariable Long idGrupo) {
        return ResponseEntity.ok(actividadService.getActividadesPorGrupo(idGrupo));
    }

    @GetMapping("/grupo/{idGrupo}")
    public List<ActividadDTO> getActividadesByGrupo(@PathVariable Long idGrupo) {
        return actividadService.getActividadesPorGrupo(idGrupo);
    }

    @PostMapping
    public Actividad create(@RequestBody Actividad actividad) {
        return actividadService.save(actividad);
    }

    @PutMapping("/{id}")
    public Actividad update(@PathVariable Integer id, @RequestBody Actividad actividad) {
        actividad.setIdActividad(id);
        return actividadService.save(actividad);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        actividadService.deleteById(id);
    }
}
