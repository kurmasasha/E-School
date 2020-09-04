package com.jm.repository;

import com.jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT FROM User")
    List<User> getAllUsers();

    User getUserById(Long userId);
}