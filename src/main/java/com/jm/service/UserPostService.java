package com.jm.service;

import com.jm.dto.UserPostDto;
import com.jm.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPostService {
    private UserPostRepository userPostRepository;

    @Autowired
    public UserPostService(UserPostRepository userPostRepository) {
        this.userPostRepository = userPostRepository;
    }

    public Optional<UserPostDto> addUserPostDto(UserPostDto userPostDto) {
        userPostRepository.save(userPostDto);
        return Optional.of(userPostDto);
    }
}
