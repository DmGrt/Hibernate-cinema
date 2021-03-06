package com.spring.cinema.models.dto.movie;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieRequestDto {
    @NotNull
    private String title;
    private String description;
}
