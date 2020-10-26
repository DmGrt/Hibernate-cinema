package com.spring.cinema.dao.impl;

import com.spring.cinema.dao.UserDao;
import com.spring.cinema.exceptions.DataProcessingException;
import com.spring.cinema.models.User;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User add(User user) {
        return super.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery(
                    "FROM User WHERE email = :email", User.class);
            query.setParameter("email", email);
            return query.uniqueResultOptional();
        }
    }

    @Override
    public User getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't get user with id = " + id, e);
        }
    }
}
