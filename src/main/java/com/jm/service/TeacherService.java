package com.jm.service;

import com.jm.dto.TeacherUserDto;
import com.jm.dto.UserDto;

import java.util.List;

public interface TeacherService {

    boolean updateTeacherInfo(UserDto editedTeacherInfo, Long teacherId);

    boolean deactivateTeacherById(Long teacherId);

    boolean activateTeacherById(Long teacherId);

    List<TeacherUserDto> getTeachersBySearch(String search);

    UserDto getTeacherById(Long teacherId);

    TeacherUserDto getTeacherUserDtoByTeacherId(Long teacherId);
}