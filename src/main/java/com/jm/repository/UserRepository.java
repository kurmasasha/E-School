package com.jm.repository;

import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;
import com.jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new com.jm.dto.UserDto(u.id, u.email, u.firstName, u.lastName) FROM User u WHERE u.id=:userId")
    UserDto getUserDtoById(Long userId);

    List<UserDto> getAllBySearch(String search);

    List<UserDto> getAllUserDto();

    void saveUserPost(UserPostDto userPostDto);

    void deleteById(Long aLong);
}