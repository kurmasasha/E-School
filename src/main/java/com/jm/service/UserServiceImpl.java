package com.jm.service;


import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;
import com.jm.model.User;
import com.jm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserDtoById(Long userId) {
        return userRepository.getUserDtoById(userId);
    }

    @Override
    public List<UserDto> getAllUserDto(String search) {
        if (search.isEmpty()) {
            return userRepository.getAllUserDto();
        } else {

            return userRepository.getAllBySearch(search);
        }
    }

    @Override
    public boolean updateUserDto(UserDto userDto, Long userId) {
        UserDto foundUserDto = userRepository.getUserDtoById(userId);

        if (foundUserDto != null) {
            userRepository.save(new User(userDto));
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteUserDtoById(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }

    public boolean addUserPostDto(UserPostDto userPostDto) {
        userRepository.saveUserPost(userPostDto);
        return true;
    }
}
