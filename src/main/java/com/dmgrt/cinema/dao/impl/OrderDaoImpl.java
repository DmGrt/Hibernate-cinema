package com.dmgrt.cinema.dao.impl;

import com.dmgrt.cinema.dao.OrderDao;
import com.dmgrt.cinema.exceptions.DataProcessingException;
import com.dmgrt.cinema.lib.Dao;
import com.dmgrt.cinema.models.Order;
import com.dmgrt.cinema.models.User;
import com.dmgrt.cinema.util.HibernateUtil;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.query.Query;

@Dao
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    @Override
    public Order add(Order order) {
        return super.add(order);
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> query = session.createQuery("FROM Order o "
                    + "JOIN FETCH o.tickets "
                    + "WHERE o.user = :user", Order.class);
            query.setParameter("user", user);
            return query.getResultList().stream()
                    .distinct()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new DataProcessingException("Can't get " + user + " orders", e);
        }
    }
}
