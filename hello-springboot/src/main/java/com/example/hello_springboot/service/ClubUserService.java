package com.example.hello_springboot.service;

import com.example.hello_springboot.db.ClubRepository;
import com.example.hello_springboot.db.ClubUserRepository;
import com.example.hello_springboot.model.ClubUserRequest;
import com.example.hello_springboot.model.ClubUserResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ClubUserService {
    private final ClubUserRepository clubUserRepository;
    private final ClubRepository clubRepository;

    public void register(Long clubId, Long userId) {
        var club = clubRepository.findById(clubId).get();
        var user = clubUserRepository.findById(userId).get();
        club.addUser(user);
        clubRepository.save(club);
    }


    public void update(Long clubId, ClubUserRequest.UpdateRequest updateRequest, Long userId) {
        var club = clubRepository.findById(clubId).get();
        var user = clubUserRepository.findById(userId).get();
        user.setName(updateRequest.getName());
        club.updateUser(user);
        clubUserRepository.save(user);
        clubRepository.save(club);

    }

    public void delete(Long clubId, Long userId) {
        var club = clubRepository.findById(clubId).get();
        var user = clubUserRepository.findById(userId).get();
        club.deleteUser(user);
        clubRepository.save(club);
    }


    public ClubUserResponse.RetrieveAllResponse findAll(Long clubId) {
        var club = clubRepository.findById(clubId).get();
        var dtos = club.getUserEntities().stream().map(user -> {
            var dto = ClubUserResponse.RetrieveOneResponse.builder()
                    .id(user.getId())
                    .userName(user.getName())
                    .build();
            return dto;
        }).toList();
        var response = ClubUserResponse.RetrieveAllResponse.builder().clubUsers(dtos).build();
        return response;
    }


}
