package com.example.demo.service;

import ch.qos.logback.core.util.StringUtil;
import com.example.demo.domain.dto.PlaylistSearchDto;
import com.example.demo.domain.entity.PlayList;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.request.PlayListRequest;
import com.example.demo.domain.response.PlayListResponse;
import com.example.demo.respository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayListServiceImpl implements PlayListService{
    private final PlayListRepository playListRepository;
    @Override
    public void addPlayList(PlayListRequest playListRequest, User user) {
        PlayList playList = playListRequest.toEntity(user);
        playListRepository.save(playList);
    }

    @Override
    public List<PlayListResponse> search(PlaylistSearchDto searchDto) {
        if (StringUtil.notNullNorEmpty(searchDto.name())) return getPlayListByNameContaining(searchDto.name());
        return getAll();
    }

    @Override
    public void deletePlayListById(Long id) {
        playListRepository.deleteById(id);
    }
    @Override
    public void updatePlayListById(Long id, PlayListRequest playListRequest) {
        // TODO: 구현 필요
    }
    @Override
    public List<PlayListResponse> getPlayListByNameContaining(String name) {
        return playListRepository.findByNameContaining(name)
                .stream()
                .map(PlayListResponse::from)
                .toList();
    }
    @Override
    public PlayListResponse getPlayListById(Long id) {
        return playListRepository
                .findById(id)
                .map(PlayListResponse::from)
                .orElseThrow();
    }
    @Override
    public List<PlayListResponse> getAll() {
        return playListRepository.findAll()
                .stream()
                .map(PlayListResponse::from)
                .toList();
    }

    @Override
    public List<PlayListResponse> myPlayList(User user) {
        return playListRepository.findByUser(user)
                .stream()
                .map(PlayListResponse::from)
                .toList();
    }
}
