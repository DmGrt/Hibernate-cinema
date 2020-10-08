package com.dmgrt.cinema.dao.impl;

import com.dmgrt.cinema.dao.MovieDao;
import com.dmgrt.cinema.lib.Dao;
import com.dmgrt.cinema.models.Movie;
import java.util.List;

@Dao
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {

    @Override
    public Movie add(Movie movie) {
        return super.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return super.getAll(Movie.class);
    }
}
