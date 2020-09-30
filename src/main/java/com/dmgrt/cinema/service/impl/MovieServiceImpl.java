package com.dmgrt.cinema.service.impl;

import com.dmgrt.cinema.dao.MovieDao;
import com.dmgrt.cinema.lib.Inject;
import com.dmgrt.cinema.lib.Service;
import com.dmgrt.cinema.models.Movie;
import com.dmgrt.cinema.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
