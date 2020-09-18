package com.jm.repository;

import com.jm.dto.UserDto;
import com.jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new com.jm.dto.UserDto(u.id, u.email, u.firstName, u.lastName) FROM User u WHERE u.id=:userId")
    UserDto getUserById(Long userId);

    @Query("SELECT new com.jm.dto.UserDto(u.id, u.email, u.firstName, u.lastName) FROM User u WHERE CONCAT(u.firstName, u.lastName) LIKE %?1")
    List<UserDto> getAllBySearch(String search);

    @Query("SELECT new com.jm.dto.UserDto(u.id, u.email, u.firstName, u.lastName) FROM User u")
    List<UserDto> getAllUsers();

    void deleteById(Long userId);

    boolean existsUserByEmail(String email);
}