package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Usuario;
import com.proyecto.cinegalaxy.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(u -> {
            u.setNombre(usuario.getNombre());
            u.setApellido(usuario.getApellido());
            u.setTelefono(usuario.getTelefono());
            u.setFechaNac(usuario.getFechaNac());
            return usuarioRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    @Override
    public Usuario deleteUsuario(Long id) {
        return usuarioRepository.findById(id).map(u -> {
            u.setEstado(0);
            return usuarioRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }
}
