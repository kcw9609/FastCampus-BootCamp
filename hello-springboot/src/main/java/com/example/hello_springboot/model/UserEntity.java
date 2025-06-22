package com.example.hello_springboot.model;

import com.example.hello_springboot.entity.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends Entity {
    private String name;

    private int score;

}
