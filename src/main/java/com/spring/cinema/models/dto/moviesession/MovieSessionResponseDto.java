package com.spring.cinema.models.dto.moviesession;

import lombok.Data;

@Data
public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long hallId;
    private String sessionTime;
}
