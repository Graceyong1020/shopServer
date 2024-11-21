package org.pgm.shopserver.service;

import org.pgm.shopserver.model.Role;
import org.pgm.shopserver.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user );
    User findByUsername(String username);
    void changeRole(Role newRole, String username);
    List<User> findAllUsers();

}
