package com.dmgrt.cinema.dao.impl;

import com.dmgrt.cinema.dao.CinemaHallDao;
import com.dmgrt.cinema.lib.Dao;
import com.dmgrt.cinema.models.CinemaHall;
import java.util.List;

@Dao
public class CinemaHallDaoImpl extends AbstractDao<CinemaHall> implements CinemaHallDao {
    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return super.add(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return super.getAll(CinemaHall.class);
    }
}
