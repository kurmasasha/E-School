package com.jm.repository;

import com.jm.dto.UserDto;
import com.jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {
    List<UserDto> getAllUserDto();

    void deleteById(Long aLong);

    UserDto getUserDtoById(Long userId);
}