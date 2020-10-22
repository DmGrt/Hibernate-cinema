package com.spring.cinema.service;

import com.spring.cinema.models.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
