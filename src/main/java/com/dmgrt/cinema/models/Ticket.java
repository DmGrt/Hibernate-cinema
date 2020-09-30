package com.dmgrt.cinema.models;

public class Ticket {
    private Long id;
    private MovieSession movieSession;
    private User user;

    public Ticket(Long id, MovieSession movieSession, User user) {
        this.id = id;
        this.movieSession = movieSession;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieSession getMovieSession() {
        return movieSession;
    }

    public void setMovieSession(MovieSession movieSession) {
        this.movieSession = movieSession;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
