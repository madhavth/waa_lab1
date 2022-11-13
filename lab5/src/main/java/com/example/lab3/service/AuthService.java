package com.example.lab3.service;

import com.example.lab3.domain.RefreshTokenRequest;
import com.example.lab3.domain.dto.requests.LoginRequest;
import com.example.lab3.domain.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
