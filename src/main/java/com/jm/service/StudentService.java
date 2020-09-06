package com.jm.service;

import com.jm.dto.ResponseDto;
import com.jm.dto.StudentUserDto;
import com.jm.dto.UserDto;

public interface StudentService {
    void updateStudent(UserDto updatedStudent, Long studentId);

    void activateStudentById(Long studentId);

    void deactivateStudentById(Long studentId);

    ResponseDto<StudentUserDto> getStudentResponse(Integer page, String search);

    UserDto getStudentById(Long studentId);
}
