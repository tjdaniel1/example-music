package com.example.demo.service;

import com.example.demo.config.jwt.JwtUtil;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.request.SigninRequest;
import com.example.demo.domain.request.SignupRequest;
import com.example.demo.domain.response.TokenResponse;
import com.example.demo.domain.response.UserResponse;
import com.example.demo.respository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
    @Override
    @Transactional
    public void signup(SignupRequest request) {
        Optional<User> byEmail = userRepository.findByEmail(request.email());
        if(byEmail.isPresent()) throw new IllegalArgumentException(request.email());
        String encodedPassword = passwordEncoder.encode(request.password());
        User user = request.toEntity(encodedPassword);
        userRepository.save(user);
    }
    @Override
    public TokenResponse login(SigninRequest request) {
        Optional<User> byEmail = userRepository.findByEmail(request.email());
        if(byEmail.isEmpty() ||
                !passwordEncoder.matches(request.password(), byEmail.get().getPassword()))
            throw new IllegalArgumentException();
        String token = jwtUtil.generateToken(request.email());
        return TokenResponse.from(token);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::from)
                .toList();
    }
}
