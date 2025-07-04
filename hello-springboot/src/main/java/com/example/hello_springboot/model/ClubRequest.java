package com.example.hello_springboot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
public class ClubRequest {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "동아리 등록 요청")
    public static class RegisterRequest {
        private String clubName;     // 동아리명
        private String description;

    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "동아리 수정 요청")
    public static class UpdateRequest {
        private String clubName;
        private String description;
    }


}
