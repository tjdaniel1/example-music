package com.example.demo.controller;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.request.SigninRequest;
import com.example.demo.domain.request.SignupRequest;
import com.example.demo.domain.response.TokenResponse;
import com.example.demo.domain.response.UserResponse;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/api/v1/auth/signup")
    public void signup(@RequestBody SignupRequest request) {
        userService.signup(request);
    }

    @PostMapping("/api/v1/auth/signin")
    public TokenResponse signin(@RequestBody SigninRequest request) {
        return userService.login(request);
    }
    @GetMapping("/api/v1/auth/me")
    public UserResponse me(@AuthenticationPrincipal User user){
        return UserResponse.from(user);
    }

}
