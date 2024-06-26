package com.example.demo.service;

import ch.qos.logback.core.util.StringUtil;
import com.example.demo.domain.dto.MusicSearchDto;
import com.example.demo.domain.entity.Music;
import com.example.demo.domain.request.MusicRequest;
import com.example.demo.domain.response.MusicResponse;
import com.example.demo.domain.type.Genre;
import com.example.demo.respository.MusicDao;
import com.example.demo.respository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService, MusicDao {
    private final MusicRepository musicRepository;
    @Override
    public List<MusicResponse> search(MusicSearchDto searchDto) {
        if(StringUtil.notNullNorEmpty(searchDto.artist())) return getMusicByArtistContaining(searchDto.artist());
        if(StringUtil.notNullNorEmpty(searchDto.title())) return getMusicByTitleContaining(searchDto.title());
        if(StringUtil.notNullNorEmpty(searchDto.genre())) return getMusicByGenre(searchDto.genre());
        return getAll();
    }

    @Override
    public void addMusic(MusicRequest musicRequest) {
        Music music = musicRequest.toEntity();
        musicRepository.save(music);
    }

    @Override
    public List<MusicResponse> getAll() {
        return musicRepository.findAll()
                .stream()
                .map(MusicResponse::from)
                .toList();
    }

    @Override
    public MusicResponse getMusicById(Long id) {
        return musicRepository.findById(id)
                .map(MusicResponse::from)
                .orElseThrow();
    }

    @Override
    public void deleteMusicById(Long id) {
        getMusicById(id);
        musicRepository.deleteById(id);
    }



    @Override
    public List<MusicResponse> getMusicByTitleContaining(String name) {
        return musicRepository.findByTitleContaining(name)
                .stream()
                .map(MusicResponse::from)
                .toList();
    }

    @Override
    public List<MusicResponse> getMusicByArtistContaining(String singer) {
        return musicRepository.findByArtistContaining(singer)
                .stream()
                .map(MusicResponse::from)
                .toList();
    }

    @Override
    public List<MusicResponse> getMusicByGenre(String genreName) {
        Genre genre = Genre.valueOf(genreName);
        return musicRepository.findByGenre(genre)
                .stream()
                .map(MusicResponse::from)
                .toList();
    }
}
