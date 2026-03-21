package com.proyecto.cinegalaxy.auth;

import com.proyecto.cinegalaxy.models.Usuario;
import com.proyecto.cinegalaxy.repositories.UsuarioRepository;
import com.proyecto.cinegalaxy.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public AuthResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email o contraseña incorrectos"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Email o contraseña incorrectos");
        }

        if (usuario.getEstado() == 0) {
            throw new RuntimeException("Usuario inactivo");
        }

        String token = jwtUtil.generarToken(usuario.getEmail());
        return new AuthResponse(token, usuario.getUsuarioId(), usuario.getNombre(),
                usuario.getApellido(), usuario.getEmail());
    }

    @Override
    public AuthResponse registro(RegistroRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setTelefono(request.getTelefono());
        usuario.setEstado(1);

        usuarioRepository.save(usuario);

        String token = jwtUtil.generarToken(usuario.getEmail());
        return new AuthResponse(token, usuario.getUsuarioId(), usuario.getNombre(),
                usuario.getApellido(), usuario.getEmail());
    }
}
