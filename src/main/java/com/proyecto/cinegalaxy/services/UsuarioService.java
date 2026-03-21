package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> getUsuarios();
    Optional<Usuario> getUsuarioById(Long id);
    Usuario updateUsuario(Long id, Usuario usuario);
    Usuario deleteUsuario(Long id);
}
