package com.spring.cinema.dao.impl;

import com.spring.cinema.dao.RoleDao;
import com.spring.cinema.models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Role add(Role role) {
        return super.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Role> query = session.createQuery(
                    "FROM Role WHERE roleName = :roleName", Role.class);
            query.setParameter("roleName", roleName);
            return query.getSingleResult();
        }
    }
}
