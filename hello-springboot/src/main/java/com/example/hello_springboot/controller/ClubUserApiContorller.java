package com.example.hello_springboot.controller;

import com.example.hello_springboot.model.ClubUserRequest;
import com.example.hello_springboot.model.ClubUserResponse;
import com.example.hello_springboot.service.ClubUserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/club")
public class ClubUserApiContorller {

    final ClubUserService clubUserService;

    @Operation(summary = "동아리 가입 api", description = "동아리 가입")
    @PostMapping("/{clubId}/register/{userId}")
    public ResponseEntity<?> register(@PathVariable Long clubId, @PathVariable Long userId) {
        clubUserService.register(clubId, userId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "동아리 회원 수정 api", description = "동아리 회원 정보 수정")
    @PutMapping("{clubId}/update/{userId}")
    public void update(@PathVariable Long clubId, @RequestBody ClubUserRequest.UpdateRequest updateRequest, @PathVariable Long userId) {
        clubUserService.update(clubId, updateRequest, userId);

    }

    @Operation(summary = "동아리 회원 삭제 api", description = "동아리 회원 삭제")
    @DeleteMapping("{clubId}/delete/{userId}")
    public void delete(@PathVariable Long clubId, @PathVariable Long userId) {
        clubUserService.delete(clubId, userId);

    }

    @Operation(summary = "해당 동아리 회원 전체 조회 api", description = "동아리 회원 정보 조회")
    @GetMapping("{clubId}/find/all")
    public ResponseEntity<ClubUserResponse.RetrieveAllResponse> findAll(@PathVariable Long clubId) {
        return ResponseEntity.ok().body(clubUserService.findAll(clubId));
    }


}
