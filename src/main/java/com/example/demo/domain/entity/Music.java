package com.example.demo.domain.entity;

import com.example.demo.config.entity.BaseEntity;
import com.example.demo.domain.type.Genre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Table(name = "MUSICS")
public class Music extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "MUSIC_ID")
    private Long id;
    @Column(name = "MUSIC_TITLE")
    private String title;
    @Column(name = "MUSIC_ARTIST")
    private String artist;
    @Column(name = "MUSIC_GENRE")
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column(name = "MUSIC_DELETED")
    @Builder.Default
    private boolean deleted = false;
}
