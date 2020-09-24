package com.jm.service.student;

import com.jm.dto.StudentUserDto;
import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;

import java.util.List;

public interface StudentService {
    boolean updateStudent(UserDto updatedStudent, Long studentId);

    boolean activateStudentById(Long studentId);

    boolean deactivateStudentById(Long studentId);

    List<StudentUserDto> getStudentBySearch(String search);

    StudentUserDto getStudentById(Long studentId);

    boolean saveNewStudent(UserPostDto newStudentDto);

    UserDto getStudentByIdDto(Long teacherId);
}
