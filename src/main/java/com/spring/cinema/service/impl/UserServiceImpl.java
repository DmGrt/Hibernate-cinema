package com.spring.cinema.service.impl;

import com.spring.cinema.dao.UserDao;
import com.spring.cinema.models.User;
import com.spring.cinema.service.UserService;
import com.spring.cinema.util.HashUtil;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        byte[] salt = HashUtil.getSalt();
        user.setPassword(HashUtil.hashPassword(user.getPassword(), salt));
        user.setSalt(salt);
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
