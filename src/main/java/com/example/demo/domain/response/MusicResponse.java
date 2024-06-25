package com.example.demo.domain.response;

import com.example.demo.domain.entity.Music;

public record MusicResponse(
        Long id,
        String title,
        String artist,
        String genre
) {
    public static MusicResponse from(Music music) {
        return new MusicResponse(
                music.getId(),
                music.getTitle(),
                music.getArtist(),
                music.getGenre().name()
        );
    }
}
