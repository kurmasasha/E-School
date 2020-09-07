package com.jm.rest.admin.admin;

import com.jm.dto.*;
import com.jm.service.UserPostService;
import com.jm.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/user/admin")
public class AdminRestController {
    private UserService userService;
    private UserPostService userPostService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseDto<PageDto<UserDto>> getUserDto(@RequestParam Integer page,
                                                    @RequestParam String search) {
        List<UserDto> users = userService.getAllUserDto();
        PageDto<UserDto> pageDto = new PageDto<>(users.size(), page, 0, 0, users);
        List<FieldError> errors = new ArrayList<>();

        return new ResponseDto(Response.SC_OK, true, search, errors, pageDto);
    }

    @GetMapping("{userId}")
    public UserDto getUserDtoById(@PathVariable Long userId) {
        return userService.getUserDtoById(userId);
    }

    @PostMapping
    public ResponseEntity<?> createUserPostDto(@RequestBody UserPostDto userPostDto) {
        if ("".equals(userPostDto.getEmail())
                || "".equals(userPostDto.getFirstName())
                || "".equals(userPostDto.getLastName())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<UserPostDto> optionalUserPostDto = userPostService.addUserPostDto(userPostDto);

        if (optionalUserPostDto.isPresent()) {
            return new ResponseEntity<>(optionalUserPostDto.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{userId}")
    public ResponseEntity<?> updateUserDto(@RequestBody UserDto userDto, @PathVariable Long userId) {
        Optional<UserDto> optionalUserDto = userService.updateUserDto(userDto, userId);

        if (optionalUserDto.isPresent()) {
            return new ResponseEntity<>(optionalUserDto.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUserDto(@PathVariable Long userId) {
        userService.deleteUserDtoById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}