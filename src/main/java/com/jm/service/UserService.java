package com.jm.service;

import com.jm.dto.FieldError;
import com.jm.dto.PageDto;
import com.jm.dto.ResponseDto;
import com.jm.dto.UserDto;
import com.jm.model.User;
import com.jm.repository.UserRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public ResponseDto<UserDto> getUserResponse(Integer page, String search) {
        List<User> users = repository.getAllUsers();
        List<UserDto> usersDto = null;

        List<FieldError> errors = new ArrayList<>();
        PageDto<UserDto> pageDto = new PageDto<>(users.size(), page, 0, 0, usersDto);

        return new ResponseDto<>(Response.SC_OK, true, search, errors, pageDto);
    }
}
