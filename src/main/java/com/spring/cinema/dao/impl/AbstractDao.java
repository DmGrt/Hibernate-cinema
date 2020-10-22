package com.spring.cinema.dao.impl;

import com.spring.cinema.exceptions.DataProcessingException;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public abstract class AbstractDao<T> {
    private static final Logger logger = Logger.getLogger(AbstractDao.class);
    protected final SessionFactory sessionFactory;

    public AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T add(T item) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
            logger.info(item.getClass().getSimpleName() + " was created: " + item);
            return item;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert"
                    + item.getClass().getSimpleName() + "entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public T getById(Long id, Class clazz) {
        try (Session session = sessionFactory.openSession()) {
            Query<T> query = session.createQuery(
                    "FROM " + clazz.getSimpleName() + " WHERE id = :id");
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving " + clazz.getSimpleName(), e);
        }
    }

    public List<T> getAll(Class<T> clazz) {
        try (Session session = sessionFactory.openSession()) {
            Query<T> query = session.createQuery("from " + clazz.getSimpleName(), clazz);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all " + clazz.getSimpleName(), e);
        }
    }
}
