package com.example.hello_springboot.db;

import com.example.hello_springboot.model.ClubEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<ClubEntity, Long> {

}
