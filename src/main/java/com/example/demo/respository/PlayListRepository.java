package com.example.demo.respository;

import com.example.demo.domain.entity.PlayList;
import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayListRepository
    extends JpaRepository<PlayList, Long> {
    List<PlayList> findByNameContaining(String name);
    List<PlayList> findByUser(User user);
    List<PlayList> findByDeletedFalseOrderByCreatedDateDesc();

}
