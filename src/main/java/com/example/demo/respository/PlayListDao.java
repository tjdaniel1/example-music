package com.example.demo.respository;

import com.example.demo.domain.entity.PlayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlayListDao {
    private final PlayListRepository playListRepository;

    public PlayList findById(Long id){
        return playListRepository.findById(id).orElseThrow();
    }

    public List<PlayList> findAll(){
        return playListRepository.findByDeletedFalseOrderByCreatedDateDesc();
    }

}
