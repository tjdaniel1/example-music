package com.example.demo.controller;

import com.example.demo.domain.response.UserResponse;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userServiceImpl;
    @GetMapping("/api/v1/users")
    public List<UserResponse> user(){
        return userServiceImpl.getAll();
    }


}
