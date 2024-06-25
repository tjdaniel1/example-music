package com.example.demo.service;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.request.PlayListMusicRequest;
import com.example.demo.domain.request.PlayListRequest;

public interface PlayListSongService {
    void addMusicToPlayList(PlayListMusicRequest playListMusicRequest, User user);
    void deleteMusicFromPlayList(Long playListMusicId, Long musicId, User user);

}
