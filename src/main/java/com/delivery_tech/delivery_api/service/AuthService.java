package com.delivery_tech.delivery_api.service;

import com.delivery_tech.delivery_api.dto.request.LoginRequest;
import com.delivery_tech.delivery_api.dto.request.RegisterRequest;
import com.delivery_tech.delivery_api.dto.response.LoginResponse;
import com.delivery_tech.delivery_api.dto.response.UserResponse;
import com.delivery_tech.delivery_api.model.Usuario;

public interface AuthService {

    // Cluásula número 1: Deve saber como processar um login
    LoginResponse login(LoginRequest request);

    // Cluásula número 2: Deve saber como registrar um novo usuário
    Usuario register(RegisterRequest request);

    // Cluásula número 3: Deve saber como obter informações do usuário autenticado
    UserResponse getCurrentUser();

}
