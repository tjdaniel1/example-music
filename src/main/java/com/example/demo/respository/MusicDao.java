package com.example.demo.respository;

import com.example.demo.domain.response.MusicResponse;

import java.util.List;

public interface MusicDao {
    List<MusicResponse> getAll();
    List<MusicResponse> getMusicByTitleContaining(String name);
    List<MusicResponse> getMusicByArtistContaining(String singer);
    List<MusicResponse> getMusicByGenre(String genre);
}
