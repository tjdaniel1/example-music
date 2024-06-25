package com.example.demo;

import com.example.demo.domain.entity.Music;
import com.example.demo.domain.entity.PlayList;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.type.Genre;
import com.example.demo.respository.MusicRepository;
import com.example.demo.respository.PlayListRepository;
import com.example.demo.respository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Test
    void contextLoads() {

    }

}
