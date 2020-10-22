package com.spring.cinema.dao.impl;

import com.spring.cinema.dao.TicketDao;
import com.spring.cinema.models.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Ticket add(Ticket ticket) {
        return super.add(ticket);
    }
}
