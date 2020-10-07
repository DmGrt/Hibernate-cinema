package com.dmgrt.cinema.service;

import com.dmgrt.cinema.models.CinemaHall;
import java.util.List;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}
