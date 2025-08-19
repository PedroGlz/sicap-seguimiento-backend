package com.sicap.sciap_seguimiento_backend.controller;

import com.sicap.sciap_seguimiento_backend.dto.ActividadDTO;
import com.sicap.sciap_seguimiento_backend.dto.ProyectoDTO;
import com.sicap.sciap_seguimiento_backend.entity.Cliente;
import com.sicap.sciap_seguimiento_backend.entity.Proyecto;
import com.sicap.sciap_seguimiento_backend.entity.Usuario;
import com.sicap.sciap_seguimiento_backend.service.ClienteService;
import com.sicap.sciap_seguimiento_backend.service.ProyectoService;
import com.sicap.sciap_seguimiento_backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;

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
    public ResponseEntity<Proyecto> crear(@RequestBody ProyectoDTO proyectoDTO) {
        Long usuarioId = obtenerUsuarioLogueado();

        Proyecto proyecto = new Proyecto();
        proyecto.setNombreProyecto(proyectoDTO.getNombreProyecto());
        proyecto.setPo(proyectoDTO.getPo());

        // Aquí deberás buscar el cliente por id y asignarlo
        Cliente cliente = clienteService.obtenerPorId(proyectoDTO.getIdCliente())
                .orElse(null);
        proyecto.setCliente(cliente);

        Proyecto proyectoCreado = proyectoService.crearProyecto(proyecto, usuarioId);

        return ResponseEntity.ok(proyectoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizar(@PathVariable Integer id, @RequestBody ProyectoDTO proyectoDTO) {
        return proyectoService.obtenerPorId(id).map(p -> {
            p.setNombreProyecto(proyectoDTO.getNombreProyecto());
            p.setPo(proyectoDTO.getPo());

            // Asignar solo el idCliente
            Cliente cliente = clienteService.obtenerPorId(proyectoDTO.getIdCliente())
                    .orElse(null);
            p.setCliente(cliente);

            return ResponseEntity.ok(proyectoService.guardar(p));
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

    private Long obtenerUsuarioLogueado() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();

        String username = null;

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else if (principal instanceof String) {
            username = (String) principal;
        }

        if (username == null) {
            throw new RuntimeException("Usuario no autenticado");
        }

        Usuario usuario = usuarioService.findByUsername(username);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado en base de datos");
        }
        return usuario.getIdUsuario();
    }
}
