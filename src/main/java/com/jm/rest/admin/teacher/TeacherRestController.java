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

import java.util.List;

@RestController
@RequestMapping("/api/admin/user/teacher")
public class TeacherRestController {

    private final TeacherService service;

    public TeacherRestController(TeacherService service) {
        this.service = service;
    }

    /**
     * GET метод, возвращающий список учителей по параметру поиска
     *
     * @param page - номер страницы
     * @param search - параметр поиска
     * @return - список учителей, удовлетворяющий критериям поиска. Если параметр поиска пуст, то возвращаются все учителя
     */
    @GetMapping
    public ResponseDto<?> getTeachersBySearch(@RequestParam Integer page,
                                              @RequestParam String search) {
        List<TeacherUserDto> teachers = service.getTeachersBySearch(search);
        PageDto<TeacherUserDto> pageDto = new PageDto<>(teachers.size(), page, 0, 0, teachers);
        return ResponseDto.ok(pageDto);
    }

    /**
     * GET метод, возвращающий одного учителя по его id
     *
     * @param teacherId - уникальный id учителя
     * @return - учитель, id которого равен заданному id
     */
    @GetMapping("/{teacherId}")
    public UserDto getTeacherById(@PathVariable Long teacherId) {
        return service.getTeacherById(teacherId);
    }

    /**
     * POST метод, добавляющий учителя в базу
     *
     * @param newTeacher - новые данные, которые должны быть записаны в базу
     * @return - статус окончания работы метода и информация, которая была записана в базу
     */
    @PostMapping
    public ResponseDto<?> saveNewTeacher(@RequestBody UserPostDto newTeacher) {
        service.saveNewTeacher(newTeacher);
        return ResponseDto.ok(newTeacher);
    }

    /**
     * PUT метод, обновляющий запись учителя
     *
     * @param editedTeacherInfo - обновлённая информация об учителе, которого требуется обновить
     * @param teacherId - id учителя, которого требуется обновить
     * @return - обновлённая информация об учителе
     */
    @PutMapping("/{teacherId}")
    public ResponseDto<?> updateTeacherInfo(@RequestBody UserDto editedTeacherInfo, @PathVariable Long teacherId) {
        if (service.updateTeacherInfo(editedTeacherInfo, teacherId)) {
            TeacherUserDto teacher = service.getTeacherUserDtoByTeacherId(teacherId);
            return ResponseDto.ok(teacher);
        } else {
            return ResponseDto.error().build();
        }
    }

    /**
     * PATCH метод, деактивирующий запись учителя
     *
     * @param teacherId - id учителя, которого требуется деактивировать
     * @return - запись деактивированного учителя
     */
    @PatchMapping("/{teacherId}/deactivate")
    public ResponseDto<?> deactivateTeacher(@PathVariable Long teacherId) {
        if (service.deactivateTeacherById(teacherId)) {
            TeacherUserDto teacher = service.getTeacherUserDtoByTeacherId(teacherId);
            return ResponseDto.ok(teacher);
        } else {
            return ResponseDto.error().build();
        }
    }

    /**
     * PATCH метод, активирующий запись учителя
     * @param teacherId - id учителя, которого требуется активировать
     * @return - запись активированного учителя
     */
    @PatchMapping("/{teacherId}/activate")
    public ResponseDto<?> activateTeacher(@PathVariable Long teacherId) {
        if (service.activateTeacherById(teacherId)) {
            TeacherUserDto teacher = service.getTeacherUserDtoByTeacherId(teacherId);
            return ResponseDto.ok(teacher);
        } else {
            return ResponseDto.error().build();
        }
    }
}