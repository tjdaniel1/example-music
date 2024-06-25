package com.example.demo.domain.entity;

import com.example.demo.config.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS", indexes = {
        @Index(name = "IDX_USERS_EMAIL", columnList = "USER_EMAIL")
})
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity implements UserDetails {
    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "USER_EMAIL", unique = true)
    private String email;
    @Column(name = "USER_PASSWORD")
    private String password;
    @Column(name = "USER_DELETED")
    @Builder.Default
    private boolean deleted = false;
    @OneToMany(mappedBy = "user")
    private Set<PlayList> playList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
