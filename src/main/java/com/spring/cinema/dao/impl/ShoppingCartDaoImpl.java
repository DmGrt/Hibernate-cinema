package com.spring.cinema.dao.impl;

import com.spring.cinema.dao.ShoppingCartDao;
import com.spring.cinema.exceptions.DataProcessingException;
import com.spring.cinema.models.ShoppingCart;
import com.spring.cinema.models.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImpl extends AbstractDao<ShoppingCart> implements ShoppingCartDao {
    private static final Logger logger = Logger.getLogger(ShoppingCartDaoImpl.class);
    private final SessionFactory sessionFactory;

    public ShoppingCartDaoImpl(SessionFactory sessionFactory, SessionFactory sessionFactory1) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory1;
    }

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        return super.add(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Query<ShoppingCart> query = session.createQuery(
                    "FROM ShoppingCart c "
                            + "LEFT JOIN FETCH c.tickets "
                            + "JOIN FETCH c.user "
                            + "WHERE c.user = :user", ShoppingCart.class);
            query.setParameter("user", user);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get cart for user: " + user, e);
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
            logger.info("Shopping cart was updated: " + shoppingCart);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException(
                    "Can't update shoppingCart: " + shoppingCart, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
