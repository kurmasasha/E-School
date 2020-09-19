package com.jm.repository;

import com.jm.dto.UserDto;
import com.jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с юзерами
 *
 * @author Java Mentor
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * метод получения юзера из БД по ID
     *
     * @param userId ID юзера
     * @return UserDto, который содержит данные юзера
     */
    @Query("SELECT new com.jm.dto.UserDto(u.id, u.email, u.firstName, u.lastName) FROM User u WHERE u.id=:userId")
    UserDto findUserById(Long userId);

    /**
     * метод извлечения юзеров из базы по поисковому запросу (поиск по имени и фамилии)
     *
     * @param search поисковой запрос
     * @return List<UserDto>, который содержит данные юзеров
     */
    @Query("SELECT new com.jm.dto.UserDto(u.id, u.email, u.firstName, u.lastName) FROM User u WHERE CONCAT(u.firstName, u.lastName) LIKE %?1%")
    List<UserDto> getAllBySearch(String search);

    /**
     * метод извлечения всех юзеров из БД
     *
     * @return List<UserDto>, который содержит данные юзеров
     */
    @Query("SELECT new com.jm.dto.UserDto(u.id, u.email, u.firstName, u.lastName) FROM User u")
    List<UserDto> getAllUsers();

    /**
     * метод удаления из БД
     *
     * @param userId ID юзера
     */
    void deleteById(Long userId);

    /**
     * метод проверки существования юзера в БД
     *
     * @param email email юзера
     * @return boolean, который содержит булев результат
     */
    boolean existsUserByEmail(String email);
}