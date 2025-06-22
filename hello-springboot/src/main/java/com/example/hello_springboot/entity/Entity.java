package com.example.hello_springboot.entity;

import lombok.Data;

@Data
public abstract class Entity implements PrimaryKey {
    private Long id;
}
