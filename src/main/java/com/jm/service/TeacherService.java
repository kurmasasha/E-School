package com.jm.service;

import com.jm.dto.ResponseDto;
import com.jm.dto.TeacherUserDto;
import com.jm.dto.UserDto;

public interface TeacherService {

    void updateTeacherInfo(UserDto editedTeacherInfo, Long teacherId);

    void deactivateTeacherById(Long teacherId);

    void activateTeacherById(Long teacherId);

    ResponseDto<TeacherUserDto> getTeacherResponse(Integer page, String search);

    UserDto getTeacherById(Long teacherId);
}
