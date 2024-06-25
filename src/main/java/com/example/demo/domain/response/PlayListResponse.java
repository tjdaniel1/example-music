package com.example.demo.domain.response;

import com.example.demo.domain.entity.PlayList;

public record PlayListResponse(
        Long id,
        String name,
        String description

) {
    public static PlayListResponse from(PlayList playList) {
        return new PlayListResponse(playList.getId(), playList.getName(), playList.getDescription());
    }
}
