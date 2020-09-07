package com.jm.repository;

import com.jm.dto.TeacherUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherUserDto, Long> {

    @Query("SELECT FROM User u WHERE u.role = 'teacher'")
    List<TeacherUserDto> getAllTeachers();

    TeacherUserDto getTeacherUserDtoByTeacherId(Long teacherId);
}
