package com.spring.cinema.dao;

import com.spring.cinema.models.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);

    Movie getById(Long id);

    List<Movie> getAll();
}
