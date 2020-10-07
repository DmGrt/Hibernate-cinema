package com.dmgrt.cinema.service.impl;

import com.dmgrt.cinema.dao.UserDao;
import com.dmgrt.cinema.lib.Inject;
import com.dmgrt.cinema.lib.Service;
import com.dmgrt.cinema.models.User;
import com.dmgrt.cinema.service.UserService;
import com.dmgrt.cinema.util.HashUtil;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

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
}
