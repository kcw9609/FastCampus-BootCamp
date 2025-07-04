package com.example.hello_springboot.service;

import com.example.hello_springboot.db.ClubUserRepository;
import com.example.hello_springboot.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ClubUserRepository userRepository;

    public UserEntity save(UserEntity user) {
        // save
        return userRepository.save(user);

    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
