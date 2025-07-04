package com.example.hello_springboot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
public class ClubUserResponse {


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "유저 검색 응담")
    public static class RetrieveOneResponse {
        private Long id;
        private String userName;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "유저 검색 리스트 응담")
    public static class RetrieveAllResponse {
        private List<RetrieveOneResponse> clubUsers;
    }


}