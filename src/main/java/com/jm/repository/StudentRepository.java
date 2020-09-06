package com.jm.repository;

import com.jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<User,Long> {

    @Query(value = "select * from users where role = student",nativeQuery = true)
    List<User> getAllStudents();

    User getStudentById(Long studentId);
}
