package com.jm.service;

import com.jm.dto.ResponseDto;
import com.jm.dto.StudentUserDto;
import com.jm.dto.UserDto;
import com.jm.model.User;

import java.util.Optional;

public interface StudentService {
    void updateStudent(UserDto updatedStudent, Long studentId);

    void activateStudentById(Long studentId);

    void deactivateStudentById(Long studentId);

    ResponseDto<StudentUserDto> getStudentResponse(Integer page, String search);

    Optional<User> getStudentById(Long studentId);
}
