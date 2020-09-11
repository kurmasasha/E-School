package com.jm.repository.user;

import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;
import com.jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.lang.Nullable;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new com.jm.dto.UserDto(u.id, u.email, u.firstName, u.lastName) FROM User u WHERE u.id=:userId")
    UserDto getUserDtoById(Long userId);

    List<User> getAllByEmailAndFirstNameAndLastName(String search);

    // List<UserDto> getAllUserDto();
    List<User> getAllUser();

    // Куда добавлять UserPostDto? (email, firstName, lastName)
    void saveUserPost(UserPostDto userPostDto);

    void deleteById(@Nullable Long userId);

    // Новый метод
    boolean existsUserByEmail(String email);
}