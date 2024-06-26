package com.example.demo.respository;

import com.example.demo.domain.response.MusicResponse;

import java.util.List;

public class MusicDaoImpl implements MusicDao{
    @Override
    public List<MusicResponse> getAll() {
        return List.of();
    }

    @Override
    public List<MusicResponse> getMusicByTitleContaining(String name) {
        return List.of();
    }

    @Override
    public List<MusicResponse> getMusicByArtistContaining(String singer) {
        return List.of();
    }

    @Override
    public List<MusicResponse> getMusicByGenre(String genre) {
        return List.of();
    }
}
