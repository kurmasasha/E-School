package com.jm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<User, Long> {

    @Query("SELECT FROM User u WHERE u.role = 'teacher'")
    List<User> getAllTeachers();

    User getTeacherById(Long teacherId);
}
