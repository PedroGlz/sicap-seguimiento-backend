package com.sicap.sciap_seguimiento_backend.controller;

import com.sicap.sciap_seguimiento_backend.dto.LoginRequest;
import com.sicap.sciap_seguimiento_backend.dto.LoginResponse;
import com.sicap.sciap_seguimiento_backend.entity.Usuario;
import com.sicap.sciap_seguimiento_backend.repository.UsuarioRepository;
import com.sicap.sciap_seguimiento_backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<Usuario> usuarioOpt = usuarioRepository
                .findByUsuarioAndPassword(request.getUsuario(), request.getPassword());

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            // Armar respuesta
            LoginResponse response = new LoginResponse();
            response.setIdUsuario(usuario.getIdUsuario());
            response.setNombre(usuario.getNombre());
            response.setNombreCompleto(usuario.getNombre() + " " +
                    usuario.getApellidoPaterno() + " " +
                    usuario.getApellidoMaterno());
            response.setNumeroEmpleado(usuario.getNumeroEmpleado());
            response.setUsuario(usuario.getUsuario());
            response.setCorreo(usuario.getCorreo());
            response.setTelefono(usuario.getTelefono());
            response.setIdTipoUsuario(usuario.getIdTipoUsuario());
            response.setCostoPorHora(usuario.getCostoPorHora());

            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Credenciales inválidas");
    }

}