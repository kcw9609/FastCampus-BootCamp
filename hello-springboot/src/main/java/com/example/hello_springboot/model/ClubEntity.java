package com.example.hello_springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clubs")
public class ClubEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<UserEntity> userEntities = new ArrayList<>();

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = description;
    }

    public void addUser(UserEntity userEntity) {
        if (userEntity == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (IsExists(userEntity)) {
            throw new IllegalArgumentException("User already exists");
        }

        this.userEntities.add(userEntity);
        userEntity.setClub(this);
    }

    public void updateUser(UserEntity userEntity) {
        if (userEntity == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (!IsExists(userEntity)) {
            throw new IllegalArgumentException("User does not exist");
        }
        deleteUser(userEntity);
        this.userEntities.add(userEntity);
        userEntity.setClub(this);
    }

    public boolean IsExists(UserEntity userEntity) {
        boolean exists = userEntities.stream()
                .anyMatch(u -> u.getId().equals(userEntity.getId()));
        return exists;
    }

    public void deleteUser(UserEntity userEntity) {
        if (!IsExists(userEntity)) {
            throw new IllegalArgumentException("User does not exist");
        }
        this.userEntities.removeIf(u -> u.getId().equals(userEntity.getId()));
        userEntity.setClub(null);

    }


}