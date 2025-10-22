package com.delivery_tech.delivery_api.repository;

import com.delivery_tech.delivery_api.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> { 
    UserDetails findByEmail(String email);
}

