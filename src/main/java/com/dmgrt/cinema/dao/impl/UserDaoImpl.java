package com.dmgrt.cinema.dao.impl;

import com.dmgrt.cinema.dao.UserDao;
import com.dmgrt.cinema.lib.Dao;
import com.dmgrt.cinema.models.User;
import com.dmgrt.cinema.util.HibernateUtil;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Dao
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    @Override
    public User add(User user) {
        return super.add(user, User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery(
                    "FROM User WHERE email = :email", User.class);
            query.setParameter("email", email);
            return query.uniqueResultOptional();
        }
    }
}
