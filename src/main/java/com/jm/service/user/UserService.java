package com.jm.service.user;

import com.jm.dto.UserDto;
import com.jm.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserService {
    boolean isUserExist(String email);



    UserDto getUserDtoById(Long userId);

    List<UserDto> getUsersBySearch(String search);

    boolean updateUserDto(UserDto userDto, Long userId);

    boolean deleteUserDtoById(Long userId);

//    boolean addUserPostDto(UserPostDto userPostDto);
}
