package com.dmgrt.cinema.models;

import java.util.List;

public class ShoppingCart {
    private Long id;
    private List<Ticket> tickets;
    private User user;

    public ShoppingCart(Long id, List<Ticket> tickets, User user) {
        this.id = id;
        this.tickets = tickets;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
