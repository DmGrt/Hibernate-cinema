package com.dmgrt.cinema.service;

import com.dmgrt.cinema.models.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
