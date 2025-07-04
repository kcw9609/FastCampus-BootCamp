package com.example.hello_springboot.service;

import com.example.hello_springboot.db.ClubRepository;
import com.example.hello_springboot.model.ClubEntity;
import com.example.hello_springboot.model.ClubRequest;
import com.example.hello_springboot.model.ClubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClubCommandService {

    final ClubRepository clubRepository;

    public ClubEntity add(ClubRequest.RegisterRequest clubRequest) {
        var entity = ClubEntity.builder()
                .title(clubRequest.getClubName())
                .description(clubRequest.getDescription())
                .build();

        var saved = clubRepository.save(entity);

        return saved;
    }


    public void update(Long id, ClubRequest.UpdateRequest updateRequest) {
        var entity = clubRepository.findById(id).get();
        entity.setTitle(updateRequest.getClubName());
        entity.setDescription(updateRequest.getDescription());
        clubRepository.save(entity);

    }

    public void delete(Long id) {
        clubRepository.deleteById(id);


    }

    public ClubResponse.RetrieveAllResponse findAll() {
        var clubs = clubRepository.findAll();
        var dtos = clubs.stream().map(club -> {
            var dto = ClubResponse.RetrieveOneResponse.builder()
                    .id(club.getId())
                    .clubName(club.getTitle())
                    .description(club.getDescription())
                    .build();
            return dto;
        }).toList();

        var response = ClubResponse.RetrieveAllResponse.builder().clubs(dtos).build();
        return response;

    }

    public ResponseEntity<ClubResponse.RetrieveOneResponse> findById(Long id) {
        var club = clubRepository.findById(id).get();
        var dto = ClubResponse.RetrieveOneResponse.builder()
                .id(club.getId())
                .clubName(club.getTitle())
                .description(club.getDescription())
                .build();
        return ResponseEntity.ok(dto);
    }


}
