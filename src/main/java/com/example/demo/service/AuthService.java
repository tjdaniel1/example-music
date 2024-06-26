package com.example.demo.service;

import com.example.demo.domain.request.SigninRequest;
import com.example.demo.domain.request.SignupRequest;
import com.example.demo.domain.response.TokenResponse;
import com.example.demo.domain.response.UserResponse;

import java.util.List;

public interface AuthService {
    void signup(SignupRequest signupRequest);
    TokenResponse login(SigninRequest signinRequest);

}
