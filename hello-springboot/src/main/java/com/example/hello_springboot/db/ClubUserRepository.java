package com.example.hello_springboot.db;

import com.example.hello_springboot.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubUserRepository extends JpaRepository<UserEntity, Long> {

}
