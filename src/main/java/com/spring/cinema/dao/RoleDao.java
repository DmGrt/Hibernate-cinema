package com.spring.cinema.dao;

import com.spring.cinema.models.Role;

public interface RoleDao {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
