package com.spring.cinema.models.dto.moviesession;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieSessionRequestDto {
    @NotNull
    private Long movieId;
    @NotNull
    private Long hallId;
    @NotNull
    private String sessionTime;
}
