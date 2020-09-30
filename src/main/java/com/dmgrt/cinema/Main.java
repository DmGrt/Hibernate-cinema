package com.dmgrt.cinema;

import com.dmgrt.cinema.lib.Injector;
import com.dmgrt.cinema.models.Movie;
import com.dmgrt.cinema.service.MovieService;

public class Main {
    private static Injector injector = Injector.getInstance("com.dmgrt.cinema");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);

        movieService.getAll().forEach(System.out::println);
    }
}
