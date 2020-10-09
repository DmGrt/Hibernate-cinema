package com.dmgrt.cinema.service.impl;

import com.dmgrt.cinema.dao.ShoppingCartDao;
import com.dmgrt.cinema.dao.TicketDao;
import com.dmgrt.cinema.lib.Inject;
import com.dmgrt.cinema.lib.Service;
import com.dmgrt.cinema.models.MovieSession;
import com.dmgrt.cinema.models.ShoppingCart;
import com.dmgrt.cinema.models.Ticket;
import com.dmgrt.cinema.models.User;
import com.dmgrt.cinema.service.ShoppingCartService;
import java.util.ArrayList;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;
    @Inject
    private TicketDao ticketDao;

    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        ticket.setUser(user);
        ticket = ticketDao.add(ticket);
        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
        shoppingCart.getTickets().add(ticket);
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCart.setTickets(new ArrayList<>());
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTickets().clear();
        shoppingCartDao.update(shoppingCart);
    }
}
