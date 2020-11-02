package com.spring.cinema.service;

import com.spring.cinema.models.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
