package com.example.demo.domain.request;


import com.example.demo.domain.entity.User;

public record SignupRequest(
        String username,
        String email,
        String password
) {
    public SignupRequest {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email must not be blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password must not be blank");
        }
    }
    public User toEntity(String encodedPassword) {
        return User.builder()
                .username(username)
                .email(email)
                .password(encodedPassword)
                .build();
    }
}
