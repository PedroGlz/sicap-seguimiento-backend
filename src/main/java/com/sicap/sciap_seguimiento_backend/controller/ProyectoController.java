package com.sicap.sciap_seguimiento_backend.controller;

import com.sicap.sciap_seguimiento_backend.entity.Proyecto;
import com.sicap.sciap_seguimiento_backend.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<Proyecto> obtenerTodos() {
        return proyectoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerPorId(@PathVariable Integer id) {
        return proyectoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proyecto crear(@RequestBody Proyecto proyecto) {
        return proyectoService.guardar(proyecto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizar(@PathVariable Integer id, @RequestBody Proyecto proyecto) {
        return proyectoService.obtenerPorId(id).map(p -> {
            proyecto.setIdProyecto(id);
            return ResponseEntity.ok(proyectoService.guardar(proyecto));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (proyectoService.obtenerPorId(id).isPresent()) {
            proyectoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}