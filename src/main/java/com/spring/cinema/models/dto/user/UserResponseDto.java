package com.spring.cinema.models.dto.user;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String password;
}
