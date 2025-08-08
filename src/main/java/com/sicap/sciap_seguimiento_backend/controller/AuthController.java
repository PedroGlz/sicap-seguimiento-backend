package com.sicap.sciap_seguimiento_backend.controller;

import com.sicap.sciap_seguimiento_backend.config.JwtTokenUtil;
import com.sicap.sciap_seguimiento_backend.dto.LoginRequest;
import com.sicap.sciap_seguimiento_backend.dto.LoginResponse;
import com.sicap.sciap_seguimiento_backend.entity.Usuario;
import com.sicap.sciap_seguimiento_backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;  // Inyecta tu util para token

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Logger logger = LoggerFactory.getLogger(AuthController.class);
        try {
            logger.info("Intentando login para usuario: {}", request.getUsuario());

            // 1. Autenticar al usuario con tu servicio
            Usuario usuario = loginService.login(request.getUsuario(), request.getPassword());
            logger.info("Usuario encontrado: {}", usuario.getUsuario());

            // 2. Crear UserDetails para el token (sin roles, o con roles si los manejas)
            UserDetails userDetails = org.springframework.security.core.userdetails.User
                    .withUsername(usuario.getUsuario())
                    .password(usuario.getPassword())
                    .authorities(new ArrayList<>()) // o agregar roles si los manejas
                    .build();
            logger.info("UserDetails creado para usuario: {}", userDetails.getUsername());

            // 3. Generar token con JwtTokenUtil
            String token = jwtTokenUtil.generateToken(userDetails);
            logger.info("Token generado: {}", token);

            // 4. Crear respuesta y asignar token
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

            response.setToken(token);

            logger.info("Login exitoso para usuario: {}", usuario.getUsuario());
            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            logger.error("Error en login para usuario: {} - {}", request.getUsuario(), e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

}
