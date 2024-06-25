package com.example.demo.controller;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.request.PlayListRequest;
import com.example.demo.domain.response.PlayListResponse;
import com.example.demo.service.MusicService;
import com.example.demo.service.PlayListService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlayListController {
    private final PlayListService playListService;

    @GetMapping("/api/v1/playlists/my")
    public List<PlayListResponse> getPlayList(@AuthenticationPrincipal User user){
        return playListService.myPlayList(user);
    }
    @GetMapping("/api/v1/playlists/{id}")
    public PlayListResponse getPlayListById(@PathVariable Long id){
        return playListService.getPlayListById(id);
    }

    @PostMapping("/api/v1/playlists")
    public void addPlayList(
            @RequestBody PlayListRequest request
            , @AuthenticationPrincipal User user){
        playListService.addPlayList(request, user);
    }
    @DeleteMapping("/api/v1/playlists/{id}")
    public void deletePlayList(@PathVariable Long id){
        playListService.deletePlayListById(id);
    }
    @PutMapping("/api/v1/playlists/{id}")
    public void updatePlayList(
            @PathVariable Long id
            , @RequestBody PlayListRequest request){
        playListService.updatePlayListById(id, request);
    }


}
