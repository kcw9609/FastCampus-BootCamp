package com.example.hello_springboot.controller;

import com.example.hello_springboot.model.Api;
import com.example.hello_springboot.model.UserEntity;
import com.example.hello_springboot.model.UserRegisterRequest;
import com.example.hello_springboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/old/user")
public class UserApiController {
    private final UserService userService;

    @PostMapping()
    public Api<UserRegisterRequest> register(
            @Valid @RequestBody
            Api<UserRegisterRequest> userRegisterRequest
    ) {
        log.info("userRegisterRequest : {}", userRegisterRequest);
        var body = userRegisterRequest.getData();

        var response = Api.<UserRegisterRequest>builder()
                .data(body)
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .build();

        return response;
        }
        @PutMapping()
        public UserEntity create(
                @RequestBody UserEntity userEntity
        ) {
            return userService.save(userEntity);

        }
    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);

    }

    @GetMapping("/{id}")
    public UserEntity findById(@PathVariable Long id) {
        return userService.findById(id);
    }

}
