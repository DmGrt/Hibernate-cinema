package com.spring.cinema.dao.impl;

import com.spring.cinema.dao.MovieDao;
import com.spring.cinema.models.Movie;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {

    public MovieDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Movie add(Movie movie) {
        return super.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return super.getAll(Movie.class);
    }
}
