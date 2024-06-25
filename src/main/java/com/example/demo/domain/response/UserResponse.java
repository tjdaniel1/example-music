package com.example.demo.domain.response;

import com.example.demo.domain.entity.PlayList;
import com.example.demo.domain.entity.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record UserResponse(
        Long id,
        String name,
        String email
) {
    public static UserResponse from(User user) {
        return new UserResponse(user.getId(),
                user.getUsername(),
                user.getEmail());
    }
}
