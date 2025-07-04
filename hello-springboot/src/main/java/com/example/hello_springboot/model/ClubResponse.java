package com.example.hello_springboot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
public class ClubResponse {


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "동아리 검색 응담")
    public static class RetrieveOneResponse {
        private Long id;
        private String clubName;
        private String description;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "동아리 검색 리스트 응담")
    public static class RetrieveAllResponse {
        private List<ClubResponse.RetrieveOneResponse> clubs;
    }


}
