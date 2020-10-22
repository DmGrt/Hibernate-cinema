package com.spring.cinema.controllers;

import com.spring.cinema.models.dto.movie.MovieDtoMapper;
import com.spring.cinema.models.dto.movie.MovieRequestDto;
import com.spring.cinema.models.dto.movie.MovieResponseDto;
import com.spring.cinema.service.MovieService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieDtoMapper movieDtoMapper;

    public MovieController(MovieService movieService, MovieDtoMapper movieDtoMapper) {
        this.movieService = movieService;
        this.movieDtoMapper = movieDtoMapper;
    }

    @PostMapping
    public void add(@RequestBody MovieRequestDto movieRequestDto) {
        movieService.add(movieDtoMapper.mapToMovie(movieRequestDto));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
