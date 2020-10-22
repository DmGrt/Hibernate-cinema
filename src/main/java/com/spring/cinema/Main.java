package com.spring.cinema;

import com.spring.cinema.config.AppConfig;
import com.spring.cinema.exceptions.AuthenticationException;
import com.spring.cinema.models.CinemaHall;
import com.spring.cinema.models.Movie;
import com.spring.cinema.models.MovieSession;
import com.spring.cinema.models.User;
import com.spring.cinema.security.AuthenticationService;
import com.spring.cinema.service.CinemaHallService;
import com.spring.cinema.service.MovieService;
import com.spring.cinema.service.MovieSessionService;
import com.spring.cinema.service.OrderService;
import com.spring.cinema.service.ShoppingCartService;
import com.spring.cinema.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    private static final Logger logger = Logger.getLogger(Main.class);
    private static final CinemaHallService cinemaHallService =
            context.getBean(CinemaHallService.class);
    private static final MovieService movieService =
            context.getBean(MovieService.class);
    private static final MovieSessionService movieSessionService =
            context.getBean(MovieSessionService.class);
    private static final UserService userService =
            context.getBean(UserService.class);
    private static final AuthenticationService authenticationService =
            context.getBean(AuthenticationService.class);
    private static final ShoppingCartService shoppingCartService =
            context.getBean(ShoppingCartService.class);
    private static final OrderService orderService =
            context.getBean(OrderService.class);

    public static void main(String[] args) {
        Movie tenet = new Movie();
        tenet.setTitle("Tenet");
        movieService.add(tenet);

        Movie batman = new Movie();
        batman.setTitle("Batman");
        movieService.add(batman);

        Movie inception = new Movie();
        inception.setTitle("Inception");
        movieService.add(inception);

        movieService.getAll().forEach(logger::info);

        CinemaHall nolanHall = new CinemaHall();
        nolanHall.setCapacity(50);
        nolanHall.setDescription("Nolan hall");

        cinemaHallService.add(nolanHall);

        cinemaHallService.getAll().forEach(logger::info);

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

        logger.info(movieSessionService.findAvailableSessions(2L, LocalDate.now()));
        logger.info(movieSessionService.findAvailableSessions(3L, LocalDate.now()));

        User jake = new User();
        jake.setPassword("tort");
        jake.setEmail("jake1956@meta.ua");

        jake = authenticationService.register(jake.getEmail(), jake.getPassword());
        logger.info("Registered: " + jake);

        try {
            jake = authenticationService.login("jake1956@meta.ua", "tort");
            logger.info("Logged in: " + jake);
        } catch (AuthenticationException e) {
            logger.warn("Can't login user." + e);
        }

        shoppingCartService.addSession(inceptionSession, jake);
        shoppingCartService.addSession(tenetSession, jake);

        orderService.completeOrder(shoppingCartService.getByUser(jake).getTickets(), jake);

        logger.info("Jake's orders: " + orderService.getOrderHistory(jake));
    }
}
