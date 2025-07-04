package com.example.hello_springboot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
public class ClubUserRequest {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "동아리 유저 수정 요청")
    public static class UpdateRequest {
        private String name;
    }


}
