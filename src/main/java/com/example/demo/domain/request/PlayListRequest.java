package com.example.demo.domain.request;

import com.example.demo.domain.entity.PlayList;
import com.example.demo.domain.entity.User;

public record PlayListRequest(
        String name,
        String description
) {
    public PlayList toEntity(User user) {
        return PlayList.builder()
                .name(name)
                .user(user)
                .description(description)
                .build();
    }
}
