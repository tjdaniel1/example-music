package com.example.demo.domain.entity;

import com.example.demo.config.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PLAYLISTS")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayList extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "PLAYLIST_ID")
    private Long id;
    @Column(name = "PLAYLIST_NAME")
    private String name;
    @Column(name = "PLAYLIST_DESCRIPTION")
    @Builder.Default
    private String description = "설명을 작성해 주세요.";
    @Column(name = "PLAYLIST_DELETED")
    @Builder.Default
    private boolean deleted = false;
    @JoinColumn(name = "USER_ID")
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "playList", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<PlayListMusic> playListMusics = new HashSet<>();

    public void addMusic(Music music) {
        PlayListMusic playListMusic = PlayListMusic.builder().playList(this).music(music).build();
        this.playListMusics.add(playListMusic);
    }
}
