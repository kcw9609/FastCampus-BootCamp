package com.example.hello_springboot.service;

import com.example.hello_springboot.db.UserRepository;
import com.example.hello_springboot.model.UserEntity;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public UserEntity save(UserEntity user) {
        // save
        return userRepository.save(user);

    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

}
