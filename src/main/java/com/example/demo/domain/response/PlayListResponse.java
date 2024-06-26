package com.example.demo.domain.response;

import com.example.demo.domain.entity.PlayList;

import java.util.List;

public record PlayListResponse(
        Long id,
        String name,
        String description,
        List<MusicResponse> musics
) {
    public static PlayListResponse from(PlayList playList) {
        return new PlayListResponse(playList.getId(), playList.getName(), playList.getDescription(), playList
                .getPlayListMusics()
                .stream()
                .map(p -> MusicResponse.from(p.getMusic()))
                .toList());
    }
}
