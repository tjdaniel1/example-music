package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PLAYLIST_SONGS", indexes = {
        @Index(name = "IDX_PLAYLIST_SONGS_PLAYLIST", columnList = "PLAYLIST_ID"),
        @Index(name = "IDX_PLAYLIST_SONGS_MUSIC", columnList = "MUSIC_ID")
})
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayListMusic {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "PLAYLIST_ID")
    private PlayList playList;
    @ManyToOne
    @JoinColumn(name = "MUSIC_ID")
    private Music music;
}
