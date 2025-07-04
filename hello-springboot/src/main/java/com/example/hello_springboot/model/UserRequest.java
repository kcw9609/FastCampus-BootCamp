package com.example.hello_springboot.model;

import lombok.*;

@Data
public class UserRequest {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterRequest {
        private String userName;
    }

}