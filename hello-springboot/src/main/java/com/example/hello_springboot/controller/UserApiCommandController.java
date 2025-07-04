package com.example.hello_springboot.controller;

import com.example.hello_springboot.db.ClubUserRepository;
import com.example.hello_springboot.model.UserEntity;
import com.example.hello_springboot.model.UserRegisterRequest;
import com.example.hello_springboot.model.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiCommandController {

    final ClubUserRepository clubUserRepository;

    @Operation(summary = "회원가입 가입 api", description = "회원가입")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest.RegisterRequest registerRequest) {
        var userEntity = UserEntity.builder()
                .name(registerRequest.getUserName())
                .build();
        var saved = clubUserRepository.save(userEntity);
        return ResponseEntity.ok(saved);
    }


}
