package com.dmgrt.cinema.dao;

import com.dmgrt.cinema.models.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();
}
