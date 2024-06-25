package com.example.demo.service;

import com.example.demo.domain.entity.Music;
import com.example.demo.domain.entity.PlayList;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.request.PlayListMusicRequest;
import com.example.demo.respository.MusicRepository;
import com.example.demo.respository.PlayListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayListSongServiceImpl implements PlayListSongService{
    private final PlayListRepository playListRepository;
    private final MusicRepository musicRepository;

    @Override
    @Transactional
    public void addMusicToPlayList(PlayListMusicRequest playListMusicRequest, User user) {
        PlayList playList = playListRepository.findById(playListMusicRequest.playListId()).orElseThrow();
        Music music = musicRepository.findById(playListMusicRequest.musicId()).orElseThrow();
        playList.addMusic(music);

    }

    @Override
    @Transactional
    public void deleteMusicFromPlayList(Long playListMusicId, Long musicId, User user) {
        PlayList playList = playListRepository.findById(playListMusicId).orElseThrow();
        Music music = musicRepository.findById(musicId).orElseThrow();
        playList.getPlayListMusics().removeIf(playListMusic -> playListMusic.getMusic().equals(music));
    }
}
