package com.jm.repository;

import com.jm.dto.TeacherUserDto;
import com.jm.model.Teacher;
import com.jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    // TODO: Don't forget to add check for dtype later!!!
    @Query("SELECT new com.jm.dto.TeacherUserDto(u.id, u.email, u.firstName, u.lastName) " +
            "FROM User u ")
    List<TeacherUserDto> getAllTeachers();

    @Query("SELECT new com.jm.dto.TeacherUserDto(u.id, u.email, u.firstName, u.lastName) " +
            "FROM User u " +
            "WHERE CONCAT(u.firstName, u.lastName) LIKE %?1%")
    List<TeacherUserDto> getAllBySearch(String search);

    @Query("SELECT new com.jm.dto.TeacherUserDto(u.id, u.email, u.firstName, u.lastName) " +
            "FROM User u " +
            "WHERE u.id = :id")
    TeacherUserDto getTeacherUserDtoByTeacherId(@Param("id") Long teacherId);
}
