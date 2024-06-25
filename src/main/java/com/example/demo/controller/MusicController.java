package com.example.demo.controller;

import com.example.demo.config.aop.MusicSearchParam;
import com.example.demo.domain.dto.MusicSearchDto;
import com.example.demo.domain.request.MusicRequest;
import com.example.demo.domain.response.MusicResponse;
import com.example.demo.service.MusicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MusicController {
    private final MusicService musicService;

    @GetMapping("/api/v1/musics")
    public List<MusicResponse> musics(@MusicSearchParam MusicSearchDto searchDto){
        return musicService.search(searchDto);
    }
    @PostMapping("/api/v1/musics")
    public void addMusic(MusicRequest request){
        musicService.addMusic(request);
    }
    @DeleteMapping("/api/v1/musics/{id}")
    public void deleteMusic(@PathVariable Long id){
        musicService.deleteMusicById(id);
    }
    @GetMapping("/api/v1/musics/{id}")
    public MusicResponse getMusic(@PathVariable Long id){
        return musicService.getMusicById(id);
    }


}
