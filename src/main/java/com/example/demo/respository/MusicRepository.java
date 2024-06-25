package com.example.demo.respository;

import com.example.demo.domain.entity.Music;
import com.example.demo.domain.type.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository
    extends JpaRepository<Music, Long> {
    List<Music> findByTitleContaining(String name);
    List<Music> findByArtistContaining(String singer);
    List<Music> findByGenre(Genre genreName);
}
