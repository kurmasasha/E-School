package com.jm.rest.admin.teacher;

import com.jm.dto.*;
import com.jm.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/admin/user/teacher")
public class TeacherRestController {

    private TeacherService service;

    public TeacherRestController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseDto<TeacherUserDto> getTeacherResponse(@RequestParam Integer page,
                                                          @RequestParam String search) { // CHECK What is search in this case?
        List<TeacherUserDto> teachers = service.getTeacherResponse(page, search);
        List<FieldError> errors = new ArrayList<>();
        PageDto<TeacherUserDto> pageDto = new PageDto<>(teachers.size(), page, 0, 0, teachers);
        return new ResponseDto<>(200, true, "Some text", errors, pageDto);
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
            pageDto = new PageDto<>(teachers.size(), null, 0, 0, teachers);
            return new ResponseDto<>(HttpStatus.OK.value(), true, "Some text", errors, pageDto);
        } else {
            pageDto = new PageDto<>(0, null, 0, 0, null);
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, "Some text", errors, pageDto);
        }
    }

    @PatchMapping("/{teacherId}/deactivate")
    public ResponseDto<TeacherUserDto> deactivateTeacher(@PathVariable Long teacherId) {
        List<FieldError> errors = new ArrayList<>();
        PageDto<TeacherUserDto> pageDto;

        if (service.deactivateTeacherById(teacherId)) {
            List<TeacherUserDto> teachers = Arrays.asList(service.getTeacherUserDtoByTeacherId(teacherId));
            pageDto = new PageDto<>(teachers.size(), null, 0, 0, teachers);
            return new ResponseDto<>(HttpStatus.OK.value(), true, "Some text", errors, pageDto);
        } else {
            pageDto = new PageDto<>(0, null, 0, 0, null);
            return new ResponseDto<>(400, false, "Some text", errors, pageDto);
        }
    }

    @PatchMapping("/{teacherId}/activate")
    public ResponseDto<TeacherUserDto> activateTeacher(@PathVariable Long teacherId) {
        List<FieldError> errors = new ArrayList<>();
        PageDto<TeacherUserDto> pageDto;

        if (service.activateTeacherById(teacherId)) {
            List<TeacherUserDto> teachers = Arrays.asList(service.getTeacherUserDtoByTeacherId(teacherId));
            pageDto = new PageDto<>(teachers.size(), null, 0, 0, teachers);
            return new ResponseDto<>(HttpStatus.OK.value(), true, "Some text", errors, pageDto);
        } else {
            pageDto = new PageDto<>(0, null, 0, 0, null);
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, "Some text", errors, pageDto);
        }
    }
}