package com.spring.cinema.dao.impl;

import com.spring.cinema.dao.MovieSessionDao;
import com.spring.cinema.models.MovieSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl extends AbstractDao<MovieSession> implements MovieSessionDao {
    private final SessionFactory sessionFactory;

    public MovieSessionDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<MovieSession> query = session.createQuery(
                    "FROM MovieSession ms JOIN FETCH ms.movie JOIN FETCH ms.cinemaHall "
                            + "WHERE ms.movie.id = :movieId "
                            + "AND ms.showTime BETWEEN :startOfDay AND :endOfDay");
            query.setParameter("movieId", movieId);
            query.setParameter("startOfDay", date.atStartOfDay());
            query.setParameter("endOfDay", date.atTime(LocalTime.MAX));
            return query.getResultList();
        }
    }

    @Override
    public MovieSession add(MovieSession session) {
        return super.add(session);
    }
}
