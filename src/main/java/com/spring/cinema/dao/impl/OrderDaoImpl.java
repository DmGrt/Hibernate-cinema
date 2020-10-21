package com.spring.cinema.dao.impl;

import com.spring.cinema.dao.OrderDao;
import com.spring.cinema.exceptions.DataProcessingException;
import com.spring.cinema.models.Order;
import com.spring.cinema.models.User;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    private final SessionFactory sessionFactory;

    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Order add(Order order) {
        return super.add(order);
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        try (Session session = sessionFactory.openSession()) {
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
