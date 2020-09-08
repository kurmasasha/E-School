package com.jm.repository;

import com.jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    Optional<User> findById(Long studentId);
}
