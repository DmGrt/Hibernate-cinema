package com.spring.cinema.models.dto.moviesession;

import lombok.Data;

@Data
public class MovieSessionRequestDto {
    private Long movieId;
    private Long hallId;
    private String sessionTime;
}
