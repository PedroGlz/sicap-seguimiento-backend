package com.sicap.sciap_seguimiento_backend.service;

import com.sicap.sciap_seguimiento_backend.entity.Usuario;
import com.sicap.sciap_seguimiento_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario login(String username, String rawPassword) {
        System.out.println("Intentando login para usuario: " + username);

        return usuarioRepository.findByUsuario(username)
                .map(user -> {
                    System.out.println("Usuario encontrado: " + user.getUsuario());
                    System.out.println("Password en BD: " + user.getPassword());
                    System.out.println("Password raw: " + rawPassword);
                    boolean matches = passwordEncoder.matches(rawPassword, user.getPassword());
                    System.out.println("¿Las contraseñas coinciden? " + matches);
                    if (matches) {
                        return user;
                    } else {
                        throw new RuntimeException("Credenciales inválidas 1");
                    }
                })
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas 2"));
    }
}
