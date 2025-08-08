package com.sicap.sciap_seguimiento_backend.repository;

import com.sicap.sciap_seguimiento_backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsuarioAndPassword(String usuario, String password);
    Optional<Usuario> findByUsuario(String usuario);  // <-- Agrega este método
}
