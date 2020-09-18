package com.jm.rest.admin.teacher;

import com.jm.dto.PageDto;
import com.jm.dto.ResponseDto;
import com.jm.dto.TeacherUserDto;
import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;
import com.jm.service.teacher.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/admin/user/teacher")
public class TeacherRestController {

    private final TeacherService service;

    public TeacherRestController(TeacherService service) {
        this.service = service;
    }

    /**
     * GET метод, возвращающий список преподавателей по ключу поиска. Если запрос пустой,
     * то возвращаются все преподаватели.
     * @param page
     * @param search
     * @return
     */
    @GetMapping
    public ResponseDto<?> getTeachersBySearch(@RequestParam Integer page,
                                              @RequestParam String search) {
        List<TeacherUserDto> teachers = service.getTeachersBySearch(search);
        PageDto<TeacherUserDto> pageDto = new PageDto<>(teachers.size(), page, 0, 0, teachers);
        return ResponseDto.ok(pageDto);
    }

    /**
     * GET метод, возвращающий одного преподавателя по его id.
     * @param teacherId
     * @return
     */
    @GetMapping("/{teacherId}")
    public UserDto getTeacherById(@PathVariable Long teacherId) {
        return service.getTeacherById(teacherId);
    }

    /**
     * POST метод, добавляющий преподавателя в базу.
     * @param newTeacher
     * @return
     */
    @PostMapping
    public ResponseDto<?> saveNewTeacher(@RequestBody UserPostDto newTeacher) {
        service.saveNewTeacher(newTeacher);
        return ResponseDto.ok(newTeacher);
    }

    /**
     * PUT метод, обновляющий запись преподавателя.
     * @param editedTeacherInfo
     * @param teacherId
     * @return
     */
    @PutMapping("/{teacherId}")
    public ResponseDto<?> updateTeacherInfo(@RequestBody UserDto editedTeacherInfo, @PathVariable Long teacherId) {
        if (service.updateTeacherInfo(editedTeacherInfo, teacherId)) {
            List<TeacherUserDto> teachers = Arrays.asList(service.getTeacherUserDtoByTeacherId(teacherId));
            PageDto<TeacherUserDto> pageDto = new PageDto<>(teachers.size(), 0, 0, 0, teachers);
            return ResponseDto.ok(pageDto);
        } else {
            return ResponseDto.error().build();
        }
    }

    /**
     * PATCH метод, деактивирующий запись преподавателя.
     * @param teacherId
     * @return
     */
    @PatchMapping("/{teacherId}/deactivate")
    public ResponseDto<?> deactivateTeacher(@PathVariable Long teacherId) {
        if (service.deactivateTeacherById(teacherId)) {
            List<TeacherUserDto> teachers = Arrays.asList(service.getTeacherUserDtoByTeacherId(teacherId));
            PageDto<TeacherUserDto> pageDto = new PageDto<>(teachers.size(), 0, 0, 0, teachers);
            return ResponseDto.ok(pageDto);
        } else {
            return ResponseDto.error().build();
        }
    }

    /**
     * PATCH метод, активирующий запись преподавателя.
     * @param teacherId
     * @return
     */
    @PatchMapping("/{teacherId}/activate")
    public ResponseDto<?> activateTeacher(@PathVariable Long teacherId) {
        if (service.activateTeacherById(teacherId)) {
            List<TeacherUserDto> teachers = Arrays.asList(service.getTeacherUserDtoByTeacherId(teacherId));
            PageDto<TeacherUserDto> pageDto = new PageDto<>(teachers.size(), 0, 0, 0, teachers);
            return ResponseDto.ok(pageDto);
        } else {
            return ResponseDto.error().build();
        }
    }
}