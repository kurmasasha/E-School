package com.jm.repository;

import com.jm.dto.CourseInfoDto;
import com.jm.dto.TeacherForGroupDto;
import com.jm.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT new com.jm.dto.TeacherForGroupDto( courseInfoDto.course.id, " +
            "courseInfoDto.course.name, " +
            "courseInfoDto.course.direction.name, " +
            "courseInfoDto.curator.id) " +
            "FROM Teacher teacher WHERE teacher.course.direction.id = :directionId")
    List<TeacherForGroupDto> findAllByDirectionId(Long directionId);

}

//    private Long teacherId;
//    private String email;
//    private String firstName;
//    private String lastName;