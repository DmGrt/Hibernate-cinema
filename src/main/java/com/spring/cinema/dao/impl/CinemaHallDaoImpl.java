package com.spring.cinema.dao.impl;

import com.spring.cinema.dao.CinemaHallDao;
import com.spring.cinema.models.CinemaHall;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallDaoImpl extends AbstractDao<CinemaHall> implements CinemaHallDao {

    public CinemaHallDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return super.add(cinemaHall);
    }

    public CinemaHall getById(Long id) {
        return super.getById(id, CinemaHall.class);
    }

    @Override
    public List<CinemaHall> getAll() {
        return super.getAll(CinemaHall.class);
    }
}
