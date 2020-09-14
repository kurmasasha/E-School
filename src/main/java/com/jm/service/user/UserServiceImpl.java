package com.jm.service.user;

import com.jm.dto.UserDto;
import com.jm.model.User;
import com.jm.repository.user.UserRepository;
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
    public boolean isUserExist(String email) {
        return userRepository.existsUserByEmail(email);
    }


    @Override
    public UserDto getUserDtoById(Long userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public List<UserDto> getUsersBySearch(String search) {
        if (search.isEmpty()) {
            return userRepository.getAllUsers();
        } else {
            return userRepository.getAllBySearch(search);
        }
    }

    @Override
    public boolean updateUserDto(UserDto userDto, Long userId) {
        User user = userRepository.getOne(userId);

        if (userRepository.existsUserByEmail(user.getEmail())) {
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            userRepository.save(user);
        }

        return false;
    }

    @Override
    public boolean deleteUserDtoById(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }

//    public boolean addUserPostDto(UserPostDto userPostDto) {
//        userRepository.saveUserPost(userPostDto);
//        return true;
//    }
}