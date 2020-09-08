package com.jm.rest.admin.teacher;

import com.jm.dto.FieldError;
import com.jm.dto.PageDto;
import com.jm.dto.ResponseDto;
import com.jm.dto.TeacherUserDto;
import com.jm.dto.UserDto;
import com.jm.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/admin/user/teacher")
public class TeacherRestController {

    private final TeacherService service;

    public TeacherRestController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseDto<TeacherUserDto> getTeachersBySearch(@RequestParam Integer page,
                                                          @RequestParam String search) {
        List<TeacherUserDto> teachers = service.getTeachersBySearch(search);
        List<FieldError> errors = new ArrayList<>();
        PageDto<TeacherUserDto> pageDto = new PageDto<>(teachers.size(), page, 0, 0, teachers);
        return new ResponseDto<>(HttpStatus.OK.value(), true, "Some text", errors, pageDto);
    }

    @GetMapping("/{teacherId}")
    public UserDto getTeacherById(@PathVariable Long teacherId) {
        return service.getTeacherById(teacherId);
    }

    @PutMapping("/{teacherId}")
    public ResponseDto<TeacherUserDto> updateTeacherInfo(@RequestBody UserDto editedTeacherInfo, @PathVariable Long teacherId) {
        List<FieldError> errors = new ArrayList<>();
        PageDto<TeacherUserDto> pageDto;

        if (service.updateTeacherInfo(editedTeacherInfo, teacherId)) {
            List<TeacherUserDto> teachers = Arrays.asList(service.getTeacherUserDtoByTeacherId(teacherId));
            pageDto = new PageDto<>(teachers.size(), 0, 0, 0, teachers);
            return new ResponseDto<>(HttpStatus.OK.value(), true, "Some text", errors, pageDto);
        } else {
            pageDto = new PageDto<>(0, 0, 0, 0, Collections.emptyList());
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, "Some text", errors, pageDto);
        }
    }

    @PatchMapping("/{teacherId}/deactivate")
    public ResponseDto<TeacherUserDto> deactivateTeacher(@PathVariable Long teacherId) {
        List<FieldError> errors = new ArrayList<>();
        PageDto<TeacherUserDto> pageDto;

        if (service.deactivateTeacherById(teacherId)) {
            List<TeacherUserDto> teachers = Arrays.asList(service.getTeacherUserDtoByTeacherId(teacherId));
            pageDto = new PageDto<>(teachers.size(), 0, 0, 0, teachers);
            return new ResponseDto<>(HttpStatus.OK.value(), true, "Some text", errors, pageDto);
        } else {
            pageDto = new PageDto<>(0, 0, 0, 0, Collections.emptyList());
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, "Some text", errors, pageDto);
        }
    }

    @PatchMapping("/{teacherId}/activate")
    public ResponseDto<TeacherUserDto> activateTeacher(@PathVariable Long teacherId) {
        List<FieldError> errors = new ArrayList<>();
        PageDto<TeacherUserDto> pageDto;

        if (service.activateTeacherById(teacherId)) {
            List<TeacherUserDto> teachers = Arrays.asList(service.getTeacherUserDtoByTeacherId(teacherId));
            pageDto = new PageDto<>(teachers.size(), 0, 0, 0, teachers);
            return new ResponseDto<>(HttpStatus.OK.value(), true, "Some text", errors, pageDto);
        } else {
            pageDto = new PageDto<>(0, 0, 0, 0, Collections.emptyList());
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, "Some text", errors, pageDto);
        }
    }
}