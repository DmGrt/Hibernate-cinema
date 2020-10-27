package com.spring.cinema.models.dto.cinemahall;

import com.spring.cinema.models.CinemaHall;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallDtoMapper {
    public CinemaHallResponseDto mapToDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto hallDto = new CinemaHallResponseDto();
        hallDto.setId(cinemaHall.getId());
        hallDto.setDescription(cinemaHall.getDescription());
        hallDto.setCapacity(cinemaHall.getCapacity());
        return hallDto;
    }

    public CinemaHall mapToHall(CinemaHallRequestDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(requestDto.getDescription());
        cinemaHall.setCapacity(requestDto.getCapacity());
        return cinemaHall;
    }
}
