package com.example.demo.domain.request;

import com.example.demo.domain.entity.Music;
import com.example.demo.domain.type.Genre;

public record MusicRequest(
    String title,
    String artist,
    String genre
) {
    public MusicRequest {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be blank");
        }
        if (artist == null || artist.isBlank()) {
            throw new IllegalArgumentException("Artist must not be blank");
        }
        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre must not be blank");
        }
    }
    public Music toEntity() {
        return Music.builder()
                .title(title)
                .artist(artist)
                .genre(Genre.valueOf(genre))
                .build();
    }
}
