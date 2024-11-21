package org.pgm.shopserver.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pgm.shopserver.dto.UserDTO;
import org.pgm.shopserver.model.Role;
import org.pgm.shopserver.model.User;
import org.pgm.shopserver.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    private final PasswordEncoder passwordEncoder;

    public UserDTO saveUser(UserDTO userDTO){
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user=dtoToEntity(userDTO);
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());
        return entityToDto(userRepository.save(user));
    }

    @Override
    public UserDTO findByUsername(String username) {
        return null;
    }


    @Override
    @Transactional
    public void changeRole(Role newRole, String username) {
        userRepository.updateUserRole(username, newRole);
    }
    @Override
    public List<UserDTO> findAllUsers() {
        List<UserDTO> userDTOS=userRepository.findAll().stream()
                .map(user -> entityToDto(user))
                .collect(Collectors.toList());
        return userDTOS;
    }

}
