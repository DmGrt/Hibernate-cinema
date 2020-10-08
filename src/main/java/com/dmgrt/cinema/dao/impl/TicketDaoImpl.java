package com.dmgrt.cinema.dao.impl;

import com.dmgrt.cinema.dao.TicketDao;
import com.dmgrt.cinema.lib.Dao;
import com.dmgrt.cinema.models.Ticket;

@Dao
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        return super.add(ticket);
    }
}
