package com.example.demo.service;

import com.example.demo.domain.entity.PlayList;
import com.example.demo.respository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayListServiceSupportImpl implements PlayListServiceSupport{
    private final PlayListRepository repository;
    @Override
    public PlayList findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
