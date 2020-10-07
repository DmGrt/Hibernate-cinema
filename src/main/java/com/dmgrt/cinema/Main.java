package com.dmgrt.cinema;

import com.dmgrt.cinema.exceptions.AuthenticationException;
import com.dmgrt.cinema.lib.Injector;
import com.dmgrt.cinema.models.CinemaHall;
import com.dmgrt.cinema.models.Movie;
import com.dmgrt.cinema.models.MovieSession;
import com.dmgrt.cinema.security.AuthenticationService;
import com.dmgrt.cinema.service.CinemaHallService;
import com.dmgrt.cinema.service.MovieService;
import com.dmgrt.cinema.service.MovieSessionService;
import com.dmgrt.cinema.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static Injector injector = Injector.getInstance("com.dmgrt.cinema");
    private static final CinemaHallService cinemaHallService = (CinemaHallService) injector
            .getInstance(CinemaHallService.class);
    private static final MovieService movieService =
            (MovieService) injector.getInstance(MovieService.class);
    private static final MovieSessionService movieSessionService =
            (MovieSessionService) injector.getInstance(MovieSessionService.class);
    private static final UserService userService =
            (UserService) injector.getInstance(UserService.class);
    private static final AuthenticationService authenticationService =
            (AuthenticationService) injector.getInstance(AuthenticationService.class);

    public static void main(String[] args) throws AuthenticationException {
        Movie tenet = new Movie();
        tenet.setTitle("Tenet");
        movieService.add(tenet);

        Movie batman = new Movie();
        batman.setTitle("Batman");
        movieService.add(batman);

        Movie inception = new Movie();
        inception.setTitle("Inception");
        movieService.add(inception);

        movieService.getAll().forEach(System.out::println);

        CinemaHall nolanHall = new CinemaHall();
        nolanHall.setCapacity(50);
        nolanHall.setDescription("Nolan hall");
        
        cinemaHallService.add(nolanHall);

        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession tenetSession = new MovieSession();
        tenetSession.setMovie(tenet);
        tenetSession.setCinemaHall(nolanHall);
        tenetSession.setShowTime(LocalDateTime.now());
        movieSessionService.add(tenetSession);

        MovieSession batmanSession = new MovieSession();
        batmanSession.setMovie(batman);
        batmanSession.setCinemaHall(nolanHall);
        batmanSession.setShowTime(LocalDateTime.now());
        movieSessionService.add(batmanSession);

        MovieSession inceptionSession = new MovieSession();
        inceptionSession.setMovie(batman);
        inceptionSession.setCinemaHall(nolanHall);
        inceptionSession.setShowTime(LocalDateTime.now().plusMonths(5));
        movieSessionService.add(inceptionSession);

        System.out.println(movieSessionService.findAvailableSessions(2L, LocalDate.now()));
        System.out.println(movieSessionService.findAvailableSessions(3L, LocalDate.now()));

        System.out.println("Registered: "
                + authenticationService.register("jake1956@meta.ua", "tort"));
        System.out.println("Logged in: "
                + authenticationService.login("jake1956@meta.ua", "tort"));
    }
}
