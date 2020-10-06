package com.dmgrt.cinema.dao.impl;

import com.dmgrt.cinema.dao.MovieSessionDao;
import com.dmgrt.cinema.lib.Dao;
import com.dmgrt.cinema.models.MovieSession;
import com.dmgrt.cinema.util.HibernateUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Dao
public class MovieSessionDaoImpl extends AbstractDao<MovieSession> implements MovieSessionDao {
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MovieSession> query = session.createQuery(
                    "FROM MovieSession ms JOIN FETCH ms.movie JOIN FETCH ms.cinemaHall "
                    + "WHERE ms.movie.id = :movieId "
                    + "AND ms.showTime BETWEEN :startOfDay AND :endOfDay");
            query.setParameter("movieId", movieId);
            query.setParameter("startOfDay", startOfDay);
            query.setParameter("endOfDay", endOfDay);
            return query.getResultList();
        }
    }

    @Override
    public MovieSession add(MovieSession session) {
        return super.add(session, MovieSession.class);
    }
}
