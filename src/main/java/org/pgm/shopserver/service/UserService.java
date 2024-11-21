package org.pgm.shopserver.service;

import org.pgm.shopserver.dto.UserDTO;
import org.pgm.shopserver.model.Role;
import org.pgm.shopserver.model.User;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO );
    UserDTO findByUsername(String username);
    void changeRole(Role newRole, String username);
    List<UserDTO> findAllUsers();

    default User dtoToEntity(UserDTO userDTO) {
        User user = User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .build();
        return user;
    }

    default UserDTO entityToDto(User user) {
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .build();
        return userDTO;
    }
}
