package com.jm.service.user;

import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;
import com.jm.model.User;
import com.jm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
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
    public UserDto getUserById(Long userId) {
        return userRepository.findUserById(userId);
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
    public boolean updateUser(UserDto userDto, Long userId) {
        User user = userRepository.getOne(userId);

        if (this.isUserExist(user.getEmail())) {
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            userRepository.save(user);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }

    @Override
    public boolean saveUser(UserPostDto userPostDto) {
        User user = new User();

        user.setEmail(userPostDto.getEmail());
        user.setFirstName(userPostDto.getFirstName());
        user.setLastName(userPostDto.getLastName());
        userRepository.save(user);
        return true;
    }
}