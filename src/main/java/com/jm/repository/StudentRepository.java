package com.jm.repository;


import com.jm.dto.StudentUserDto;
import com.jm.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT new com.jm.dto.StudentUserDto(u.id, u.email, u.firstName, u.lastName) FROM User u " +
            " WHERE TYPE(u) = Student")
    List<StudentUserDto> getAllStudents();

    @Query("SELECT new com.jm.dto.StudentUserDto(u.id, u.email, u.firstName, u.lastName) FROM User u " +
            " WHERE CONCAT(u.firstName, u.lastName) LIKE %?1% AND TYPE(u) = Student")
    List<StudentUserDto> getAllBySearch(String search);

    @Query("SELECT new com.jm.dto.StudentUserDto(u.id, u.email, u.firstName, u.lastName) FROM User u " +
            " WHERE u.id = :id AND TYPE(u) = Student")
    StudentUserDto getStudentUserDtoByStudentId(@Param("id") Long studentId);


}
