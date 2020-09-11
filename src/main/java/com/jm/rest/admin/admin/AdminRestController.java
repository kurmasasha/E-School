package com.jm.rest.admin.admin;

import com.jm.dto.PageDto;
import com.jm.dto.ResponseDto;
import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;
import com.jm.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;

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

@RestController
@RequestMapping("/api/admin/user/admin")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseDto<?> getUserDto(@RequestParam Integer page,
                                     @RequestParam String search) {
        List<UserDto> users = userService.getAllUserDto(search);
        PageDto<UserDto> pageDto = new PageDto<>(users.size(), page, 0, 0, users);

        return new ResponseDto<>(Response.SC_OK, true, "OK", pageDto);
    }

    @GetMapping("{userId}")
    public UserDto getUserDtoById(@PathVariable Long userId) {
        return userService.getUserDtoById(userId);
    }

    @PostMapping
    public ResponseDto<?> createUserPostDto(@RequestBody UserPostDto userPostDto) {
        PageDto<UserPostDto> pageDto = new PageDto<>(0, 0, 0, 0, Collections.emptyList());

        if (userService.addUserPostDto(userPostDto)) {
            return new ResponseDto<>(HttpStatus.OK.value(), true, "OK", pageDto);
        } else {
            return new ResponseDto<>(HttpStatus.OK.value(), true, "Bad", pageDto);
        }
    }

    @PutMapping("{userId}")
    public ResponseDto<?> updateUserDto(@RequestBody UserDto userDto, @PathVariable Long userId) {
        PageDto<UserDto> pageDto;

        if (userService.updateUserDto(userDto, userId)) {
            List<UserDto> users = Collections.singletonList(userService.getUserDtoById(userId));
            pageDto = new PageDto<>(users.size(), 0, 0, 0, users);

            return new ResponseDto<>(HttpStatus.OK.value(), true, "OK", pageDto);
        } else {
            pageDto = new PageDto<>(0, 0, 0, 0, Collections.emptyList());

            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, "Bad", pageDto);
        }
    }

    @DeleteMapping("{userId}")
    public ResponseDto<?> deleteUserDto(@PathVariable Long userId) {
        PageDto<UserDto> pageDto = new PageDto<>(0, 0, 0, 0, Collections.emptyList());

        if (userService.deleteUserDtoById(userId)) {
            return new ResponseDto<>(HttpStatus.OK.value(), true, "OK", pageDto);
        } else {
            return new ResponseDto<>(HttpStatus.OK.value(), true, "Bad", pageDto);
        }
    }
}