package com.spring.cinema.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public static Role of(String roleName) {
        Role role = new Role();
        role.setRoleName(RoleName.valueOf(roleName));
        return role;
    }

    public enum RoleName {
        USER,
        ADMIN
    }
}
