package com.example.hello_springboot.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserRegisterRequest {

    @NotBlank
    private String name;

    private String nickname;

    @NotBlank
    @Size(min = 1 , max = 12)
    private String password;

    @NotNull
    @Max(100)
    private  Integer age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$")
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @AssertTrue(message = "name or nickName 은 존재해야 합니다.")
    public boolean nameCheck() {
        if(Objects.nonNull(name) & !name.isBlank()) {
            return true;
        }
        if (Objects.nonNull(nickname) & !nickname.isBlank()) {
            return true;
        }
        return false;
    }

}
