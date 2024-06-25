package com.example.demo.service;

import com.example.demo.domain.dto.PlaylistSearchDto;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.request.PlayListRequest;
import com.example.demo.domain.response.PlayListResponse;

import java.util.List;

public interface PlayListService {
    void addPlayList(PlayListRequest playListRequest, User user);
    void deletePlayListById(Long id);
    void updatePlayListById(Long id, PlayListRequest playListRequest);
    List<PlayListResponse> search(PlaylistSearchDto searchDto);
    List<PlayListResponse> getAll();
    List<PlayListResponse> getPlayListByNameContaining(String name);

    PlayListResponse getPlayListById(Long id);

    List<PlayListResponse> myPlayList(User user);

}
