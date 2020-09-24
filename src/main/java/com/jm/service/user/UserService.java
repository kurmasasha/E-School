package com.jm.service.user;

import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;

import java.util.List;

public interface UserService {

    /**
     * Проверяет наличие юзера в базе по email
     * @param email
     * @return
     */

    boolean isUserExist(String email);

    UserDto getUserById(Long userId);

    List<UserDto> getUsersBySearch(String search);

    boolean updateUser(UserDto userDto, Long userId);

    boolean deleteUserById(Long userId);

    boolean saveUser(UserPostDto userPostDto);
}