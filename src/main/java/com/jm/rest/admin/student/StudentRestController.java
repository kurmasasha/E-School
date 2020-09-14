package com.jm.rest.admin.student;


import com.jm.dto.*;
import com.jm.service.student.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/admin/user/student")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Search Student
    @GetMapping
    public ResponseDto<?> getStudentBySearch(@RequestParam Integer page,
                                             @RequestParam String search) {
        List<StudentUserDto> students = studentService.getStudentBySearch(search);
        PageDto<StudentUserDto> pageDto = new PageDto<>(students.size(), page, 0, 0, students);
        return ResponseDto.ok(pageDto);
    }

    //Create and Save new Student
    @PostMapping
    public ResponseDto<?> saveNewStudent(@RequestBody UserDto newStudent) {
        studentService.saveNewStudent(newStudent);
        return ResponseDto.ok(newStudent);
    }

    //Get Student By ID
    @GetMapping("/{studentId}")
    public UserDto getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentByIdDto(studentId);
    }

    //Update Student data by id and new data
    @PutMapping("/{studentId}")
    public ResponseDto<?> updateStudent(@RequestBody UserDto updatedStudent, @PathVariable Long studentId) {
        PageDto<StudentUserDto> pageDto;

        if (studentService.updateStudent(updatedStudent, studentId)) {
            List<StudentUserDto> students = Collections.singletonList(studentService.getStudentById(studentId));
            pageDto = new PageDto<>(students.size(), 0, 0, 0, students);
            return ResponseDto.ok(pageDto);
        } else {
            return ResponseDto.error().build();
        }
    }

    //Activate Student by Student ID
    @PatchMapping("/{studentId}/activate")
    public ResponseDto<?> activateStudent(@PathVariable long studentId) {
        PageDto<StudentUserDto> pageDto;

        if (studentService.activateStudentById(studentId)) {
            List<StudentUserDto> students = Collections.singletonList(studentService.getStudentById(studentId));
            pageDto = new PageDto<>(students.size(), 0, 0, 0, students);
            return ResponseDto.ok(pageDto);
        } else {
            return ResponseDto.error().build();
        }
    }

    //Deactivate Student by Student ID
    @PatchMapping("/{studentId}/deactivate")
    public ResponseDto<?> deactivateStudent(@PathVariable long studentId) {
        PageDto<StudentUserDto> pageDto;

        if (studentService.deactivateStudentById(studentId)) {
            List<StudentUserDto> students = Collections.singletonList(studentService.getStudentById(studentId));
            pageDto = new PageDto<>(students.size(), 0, 0, 0, students);
            return ResponseDto.ok(pageDto);
        } else {
            return ResponseDto.error().build();
        }
    }
}
