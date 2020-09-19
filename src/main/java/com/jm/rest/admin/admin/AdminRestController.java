package com.jm.rest.admin.admin;

import com.jm.dto.PageDto;
import com.jm.dto.ResponseDto;
import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;
import com.jm.service.user.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * Rest контроллер для администраторов
 *
 * @author Java Mentor
 * @version 1.0
 */
@RestController
@RequestMapping("/api/admin/user/admin")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    /**
     * метод получения юзеров по поисковому запросу
     *
     * @param page номер страницы
     * @param search поисковой запрос
     * @return ResponseDto, который содержит результат
     */
    @GetMapping
    public ResponseDto<?> getUsersBySearch(@RequestParam Integer page,
                                           @RequestParam String search) {
        List<UserDto> users = userService.getUsersBySearch(search);
        PageDto<UserDto> pageDto = new PageDto<>(users.size(), page, 0, 0, users);

        return ResponseDto.ok(pageDto);
    }

    /**
     * метод получения юзера по ID
     *
     * @param userId ID юзера
     * @return UserDto, который содержит данные юзера
     */
    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    /**
     * метод добавления юзера
     *
     * @param userPostDto объект, который содержит данные юзера
     * @return ResponseDto, который содержит результат
     */
    @PostMapping
    public ResponseDto<?> saveUser(@RequestBody UserPostDto userPostDto) {
        userService.saveUser(userPostDto);
        return ResponseDto.ok(userPostDto);
    }

    /**
     * метод обновления юзера по ID
     *
     * @param userDto объект, который содержит данные юзера
     * @param userId ID юзера
     * @return ResponseDto, который содержит результат
     */
    @PutMapping("/{userId}")
    public ResponseDto<?> updateUser(@RequestBody UserDto userDto, @PathVariable Long userId) {
        if (userService.updateUser(userDto, userId)) {
            List<UserDto> users = Collections.singletonList(userService.getUserById(userId));
            PageDto<UserDto> pageDto = new PageDto<>(users.size(), 0, 0, 0, users);

            return ResponseDto.ok(pageDto);
        } else {
            return ResponseDto.error().build();
        }
    }

    /**
     * метод удаления юзера по ID
     *
     * @param userId ID юзера
     * @return ResponseDto, который содержит результат
     */
    @DeleteMapping("/{userId}")
    public ResponseDto<?> deleteUser(@PathVariable Long userId) {
        PageDto<UserDto> pageDto = new PageDto<>(0, 0, 0, 0, Collections.emptyList());

        if (userService.deleteUserById(userId)) {
            return ResponseDto.ok(pageDto);
        } else {
            return ResponseDto.error().build();
        }
    }
}