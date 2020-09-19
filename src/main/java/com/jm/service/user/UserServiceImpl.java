package com.jm.service.user;

import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;
import com.jm.model.User;
import com.jm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Сервис для работы с юзерами
 *
 * @author Java Mentor
 * @version 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * метод проверки существования юзера
     *
     * @param email email юзера
     * @return boolean, который содержит булев результат
     */
    @Override
    public boolean isUserExist(String email) {
        return userRepository.existsUserByEmail(email);
    }

    /**
     * метод получения юзера по ID
     *
     * @param userId ID юзера
     * @return UserDto, который содержит данные юзера
     */
    @Override
    public UserDto getUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    /**
     * метод получения юзеров по поисковому запросу
     *
     * @param search поисковой запрос
     * @return List<UserDto>, который содержит данные юзеров
     */
    @Override
    public List<UserDto> getUsersBySearch(String search) {
        if (search.isEmpty()) {
            return userRepository.getAllUsers();
        } else {
            return userRepository.getAllBySearch(search);
        }
    }

    /**
     * метод обновления юзера
     *
     * @param userDto объект, который содержит данные юзера
     * @param userId  ID юзера
     * @return boolean, который содержит булев результат
     */
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

    /**
     * метод удаления юзера
     *
     * @param userId ID юзера
     * @return boolean, который содержит булев результат
     */
    @Override
    public boolean deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }

    /**
     * метод сохранения юзера
     *
     * @param userPostDto объект, который содержит данные юзера
     * @return boolean, который содержит булев результат
     */
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