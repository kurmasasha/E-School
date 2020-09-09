package com.jm.rest.admin.student;


import com.jm.dto.*;
import com.jm.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/admin/user/student")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseDto<StudentUserDto> getStudentBySearch(@RequestParam Integer page,
                                                          @RequestParam String search) {
        List<StudentUserDto> students = studentService.getStudentBySearch(search);
        List<FieldError> errors = new ArrayList<>();
        PageDto<StudentUserDto> pageDto = new PageDto<>(students.size(), page, 0, 0, students);
        return new ResponseDto<>(HttpStatus.OK.value(), true, "Success", errors, pageDto);
    }

    @GetMapping("/{studentId}")
    public StudentUserDto getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public ResponseDto<StudentUserDto> updateStudent(@RequestBody UserDto updatedStudent, @PathVariable Long studentId) {
        List<FieldError> errors = new ArrayList<>();
        PageDto<StudentUserDto> pageDto;

        if (studentService.updateStudent(updatedStudent, studentId)) {
            List<StudentUserDto> students = Collections.singletonList(studentService.getStudentById(studentId));
            pageDto = new PageDto<>(students.size(), 0, 0, 0, students);
            return new ResponseDto<>(HttpStatus.OK.value(), true, "Success", errors, pageDto);
        } else {
            pageDto = new PageDto<>(0, 0, 0, 0, Collections.emptyList());
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, "Error", errors, pageDto);
        }
    }

    @PatchMapping("/{studentId}/activate")
    public ResponseDto<StudentUserDto> activateStudent(@PathVariable long studentId) {
        List<FieldError> errors = new ArrayList<>();
        PageDto<StudentUserDto> pageDto;

        if (studentService.activateStudentById(studentId)) {
            List<StudentUserDto> students = Collections.singletonList(studentService.getStudentById(studentId));
            pageDto = new PageDto<>(students.size(), 0, 0, 0, students);
            return new ResponseDto<>(HttpStatus.OK.value(), true, "Success", errors, pageDto);
        } else {
            pageDto = new PageDto<>(0, 0, 0, 0, Collections.emptyList());
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, "Error", errors, pageDto);
        }
    }

    @PatchMapping("/{studentId}/deactivate")
    public ResponseDto<StudentUserDto> deactivateStudent(@PathVariable long studentId) {
        List<FieldError> errors = new ArrayList<>();
        PageDto<StudentUserDto> pageDto;

        if (studentService.deactivateStudentById(studentId)) {
            List<StudentUserDto> students = Collections.singletonList(studentService.getStudentById(studentId));
            pageDto = new PageDto<>(students.size(), 0, 0, 0, students);
            return new ResponseDto<>(HttpStatus.OK.value(), true, "Success", errors, pageDto);
        } else {
            pageDto = new PageDto<>(0, 0, 0, 0, Collections.emptyList());
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, "Error", errors, pageDto);
        }
    }
}
