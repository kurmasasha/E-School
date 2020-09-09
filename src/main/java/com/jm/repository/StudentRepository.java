package com.jm.repository;

import com.jm.dto.StudentUserDto;
import com.jm.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentUserDto, Long> {

    List<StudentUserDto> findAll();

    List<StudentUserDto> findAllBysearch(String search);

    StudentUserDto getStudentUserDtoByStudentId(Long studentId);
}
