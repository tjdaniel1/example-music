package com.example.demo.domain.response;

public record TokenResponse (
        String token,
        String tokenType
){
    public static TokenResponse from(String token){
        return new TokenResponse(token, "jwt");
    }
}
