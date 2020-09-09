package com.jm.service;

import com.jm.dto.StudentUserDto;
import com.jm.dto.UserDto;

import java.util.List;

public interface StudentService {
    boolean updateStudent(UserDto updatedStudent, Long studentId);

    boolean activateStudentById(Long studentId);

    boolean deactivateStudentById(Long studentId);

    List<StudentUserDto> getStudentBySearch(String search);

    StudentUserDto getStudentById(Long studentId);
}
