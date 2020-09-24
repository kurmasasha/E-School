package com.jm.rest.admin.student;


import com.jm.dto.*;
import com.jm.service.student.StudentService;
import com.jm.service.user.UserService;
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

    /**
     * GET метод, возвращающий список студентов по ключу поиска. Если запрос пустой,
     * то возвращаются все преподаватели.
     *
     * @param page
     * @param search
     * @return ResponseDto
     */
    @GetMapping
    public ResponseDto<?> getStudentBySearch(@RequestParam Integer page,
                                             @RequestParam String search) {
        List<StudentUserDto> students = studentService.getStudentBySearch(search);
        PageDto<StudentUserDto> pageDto = new PageDto<>(students.size(), page, 0, 0, students);
        return ResponseDto.ok(pageDto);
    }

    /**
     * POST метод, добавляющий студента в базу.
     *
     * @param newStudent
     * @return ResponseDto
     */
    @PostMapping
    public ResponseDto<?> saveNewStudent(@RequestBody UserPostDto newStudent) {
        studentService.saveNewStudent(newStudent);
        return ResponseDto.ok(newStudent);
    }

    /**
     * GET метод, возвращающий одного студента по его id.
     *
     * @param studentId
     * @return ResponseDto
     */
    @GetMapping("/{studentId}")
    public ResponseDto<?> getStudentById(@PathVariable Long studentId) {
        List<UserDto> students = Collections.singletonList(studentService.getStudentByIdDto(studentId));
        PageDto<UserDto> pageDto = new PageDto<>(students.size(), 0, 0, 0, students);
        return ResponseDto.ok(pageDto);
    }

    /**
     * PUT метод, обновляющий запись студента.
     *
     * @param updatedStudent
     * @param studentId
     * @return ResponseDto
     */
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

    /**
     * PATCH метод, активирующий запись студента.
     *
     * @param studentId
     * @return ResponseDto
     */
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

    /**
     * PATCH метод, деактивирующий запись студента.
     *
     * @param studentId
     * @return ResponseDto
     */
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
