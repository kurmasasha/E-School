package com.jm.service;

import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;

import java.util.List;

public interface UserService {
    UserDto getUserDtoById(Long userId);

    List<UserDto> getAllUserDto(String search);

    boolean updateUserDto(UserDto userDto, Long userId);

    boolean deleteUserDtoById(Long userId);

    boolean addUserPostDto(UserPostDto userPostDto);
}
