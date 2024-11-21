package org.pgm.shopserver.repository;

import org.pgm.shopserver.model.Role;
import org.pgm.shopserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username); //Optional 생략해도됨

    @Modifying
    @Query("update User set role = :role where username = :username") // :role, :username은 파라미터로 받은 값으로 대체
    void updateUserRole(@Param("username") String username, @Param("role") Role role);
}
