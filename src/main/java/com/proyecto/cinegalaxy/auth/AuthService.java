package com.proyecto.cinegalaxy.auth;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse registro(RegistroRequest request);
}
