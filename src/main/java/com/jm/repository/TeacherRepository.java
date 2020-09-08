package com.jm.repository;

import com.jm.dto.TeacherUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherUserDto, Long> {

    @Query("FROM User u WHERE u.role = 'teacher'")
    List<TeacherUserDto> getAllTeachers();

    @Query("FROM User u WHERE CONCAT(u.firstName, u.lastName) LIKE %?1%")
    List<TeacherUserDto> getAllBySearch(String search);

    TeacherUserDto getTeacherUserDtoByTeacherId(Long teacherId);
}
