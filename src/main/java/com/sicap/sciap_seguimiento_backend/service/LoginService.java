package com.sicap.sciap_seguimiento_backend.service;

import com.sicap.sciap_seguimiento_backend.entity.Usuario;
import com.sicap.sciap_seguimiento_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(String username, String password) {
        return usuarioRepository.findByUsuarioAndPassword(username, password)
                .filter(user -> user.getPassword().equals(password)) // aquí deberías usar encriptación
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
    }
}
