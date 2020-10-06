package com.dmgrt.cinema.dao.impl;

import com.dmgrt.cinema.exceptions.DataProcessingException;
import com.dmgrt.cinema.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AbstractDao<T> {

    public T add(T item, Class<T> clazz) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
            return item;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert"
                    + clazz.getSimpleName() + "entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<T> getAll(Class<T> clazz) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<T> query = session.createQuery("from " + clazz.getSimpleName(), clazz);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all " + clazz.getSimpleName(), e);
        }
    }
}
