package com.example.demo.domain.request;

public record SigninRequest(
        String email,
        String password
) {
    public SigninRequest {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email must not be blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password must not be blank");
        }
    }

}
