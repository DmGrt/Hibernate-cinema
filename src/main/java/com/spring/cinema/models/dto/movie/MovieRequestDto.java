package com.spring.cinema.models.dto.movie;

import lombok.Data;

@Data
public class MovieRequestDto {
    private String title;
    private String description;
}