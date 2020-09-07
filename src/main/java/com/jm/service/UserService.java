package com.jm.service;

import com.jm.dto.*;
import com.jm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserDtoById(Long userId) {
        return userRepository.getUserDtoById(userId);
    }

    public List<UserDto> getAllUserDto() {
        return userRepository.getAllUserDto();
    }

    public Optional<UserDto> updateUserDto(UserDto userDto, Long userId) {
        UserDto foundUserDto = userRepository.getUserDtoById(userId);

        if (foundUserDto != null) {
            userRepository.save(userDto);
            return Optional.of(userDto);
        }

        return Optional.empty();
    }

    public void deleteUserDtoById(Long userId) {
        userRepository.deleteById(userId);
    }
}
