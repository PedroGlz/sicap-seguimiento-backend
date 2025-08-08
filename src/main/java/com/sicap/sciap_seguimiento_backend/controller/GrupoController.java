package com.sicap.sciap_seguimiento_backend.controller;

import com.sicap.sciap_seguimiento_backend.entity.Grupo;
import com.sicap.sciap_seguimiento_backend.service.GrupoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping("/proyecto/{idProyecto}")
    public List<Grupo> getByIdProyecto(@PathVariable Integer idProyecto) {
        return grupoService.findByIdProyecto(idProyecto);
    }

    @GetMapping
    public List<Grupo> getAll() {
        return grupoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Grupo> getById(@PathVariable Integer id) {
        return grupoService.findById(id);
    }

    @PostMapping
    public Grupo create(@RequestBody Grupo grupo) {
        return grupoService.save(grupo);
    }

    @PutMapping("/{id}")
    public Grupo update(@PathVariable Integer id, @RequestBody Grupo grupo) {
        grupo.setIdGrupo(id);
        return grupoService.save(grupo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        grupoService.deleteById(id);
    }
}