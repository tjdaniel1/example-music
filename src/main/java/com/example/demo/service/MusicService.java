package com.example.demo.service;


import com.example.demo.domain.dto.MusicSearchDto;
import com.example.demo.domain.request.MusicRequest;
import com.example.demo.domain.response.MusicResponse;

import java.util.List;

public interface MusicService {
    void addMusic(MusicRequest musicRequest);
    MusicResponse getMusicById(Long id);
    void deleteMusicById(Long id);

    List<MusicResponse> search(MusicSearchDto searchDto);
    List<MusicResponse> getAll();
    List<MusicResponse> getMusicByTitleContaining(String name);
    List<MusicResponse> getMusicByArtistContaining(String singer);
    List<MusicResponse> getMusicByGenre(String genre);

}
