package com.example.hello_springboot.controller;

import com.example.hello_springboot.model.ClubRequest;
import com.example.hello_springboot.model.ClubResponse;
import com.example.hello_springboot.service.ClubCommandService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/club")
public class ClubApiController {

    final ClubCommandService clubCommandService;

    @Operation(summary = "동아리 생성 api", description = "동아리 생성")
    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody ClubRequest.RegisterRequest clubRequest) {
        return ResponseEntity.ok(clubCommandService.add(clubRequest));

    }

    @Operation(summary = "동아리 수정 api", description = "동아리 정보 수정")
    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody ClubRequest.UpdateRequest updateRequest) {
        clubCommandService.update(id, updateRequest);

    }

    @Operation(summary = "동아리 삭제 api", description = "동아리 삭제")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        clubCommandService.delete(id);

    }

    @Operation(summary = "동아리 조회 api", description = "선택한 동아리 정보 조회")
    @GetMapping("/find/{id}")
    public ResponseEntity<ClubResponse.RetrieveOneResponse> findById(@PathVariable Long id) {
        return clubCommandService.findById(id);
    }


    @Operation(summary = "동아리 전체 조회 api", description = "모든 동아리 정보 조회")
    @GetMapping("/find/all")
    public ResponseEntity<ClubResponse.RetrieveAllResponse> findAll() {
        var response = clubCommandService.findAll();
        return ResponseEntity.ok(response);
    }


}
