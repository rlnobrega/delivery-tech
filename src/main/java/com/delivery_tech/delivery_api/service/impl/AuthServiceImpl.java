package com.delivery_tech.delivery_api.service.impl;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.delivery_tech.delivery_api.dto.request.LoginRequest;
import com.delivery_tech.delivery_api.dto.request.RegisterRequest;
import com.delivery_tech.delivery_api.dto.response.LoginResponse;
import com.delivery_tech.delivery_api.model.Usuario;
import com.delivery_tech.delivery_api.repository.UsuarioRepository;
import com.delivery_tech.delivery_api.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements UserDetailsService, AuthService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails usuario = usuarioRepository.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com o email: " + username);
        }
        return usuario;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        throw new UnsupportedOperationException("Login ainda não implementado");
    }

    @Override
    public Usuario register(RegisterRequest request) {
        throw new UnsupportedOperationException("Registro ainda não implementado"); 
    }

/*     @Override
    public UserResponse getCurrentUser() {
        throw new UnsupportedOperationException("Usuário atual ainda não implementado");
    }
     */
}
