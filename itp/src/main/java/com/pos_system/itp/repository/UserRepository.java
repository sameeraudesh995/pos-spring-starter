package com.pos_system.itp.repository;


import com.pos_system.itp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM users WHERE email=?1",nativeQuery = true)
    Optional<User> findByEmail(String email);
}
