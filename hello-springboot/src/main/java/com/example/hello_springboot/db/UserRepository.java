package com.example.hello_springboot.db;

import com.example.hello_springboot.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

}
