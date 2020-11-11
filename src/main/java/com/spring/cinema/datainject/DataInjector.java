package com.spring.cinema.datainject;

import com.spring.cinema.models.Role;
import com.spring.cinema.models.User;
import com.spring.cinema.service.RoleService;
import com.spring.cinema.service.ShoppingCartService;
import com.spring.cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInjector {
    private static final String ADMIN_ROLE_NAME = "ADMIN";
    private static final String USER_ROLE_NAME = "USER";
    private final RoleService roleService;
    private final UserService userService;
    private final ShoppingCartService cartService;

    public DataInjector(RoleService roleService, UserService userService,
                        ShoppingCartService cartService) {
        this.roleService = roleService;
        this.userService = userService;
        this.cartService = cartService;
    }

    @PostConstruct
    public void injectData() {
        Role adminRole = Role.of(ADMIN_ROLE_NAME);
        Role userRole = Role.of(USER_ROLE_NAME);
        roleService.add(adminRole);
        roleService.add(userRole);
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");
        admin.setRoles(Set.of(adminRole));
        userService.add(admin);
        cartService.registerNewShoppingCart(admin);

        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("user");
        user.setRoles(Set.of(userRole));
        userService.add(user);
        cartService.registerNewShoppingCart(user);
    }
}
