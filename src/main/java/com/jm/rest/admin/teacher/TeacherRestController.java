package com.jm.rest.admin.teacher;

import com.jm.dto.ResponseDto;
import com.jm.dto.TeacherUserDto;
import com.jm.dto.UserDto;
import com.jm.service.TeacherService;
import org.springframework.web.bind.annotation.*;

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
        return service.getTeacherResponse(page, search);
    }

    @GetMapping("/{teacherId}")
    public UserDto getTeacherById(@PathVariable Long teacherId) {
        return service.getTeacherById(teacherId);
    }

    @PutMapping("/{teacherId}")
    public void updateTeacherInfo(@RequestBody UserDto editedTeacherInfo, @PathVariable Long teacherId) {
        service.updateTeacherInfo(editedTeacherInfo, teacherId);
    }

    @PatchMapping("/{teacherId}/deactivate")
    public void deactivateTeacher(@PathVariable Long teacherId) {
        service.deactivateTeacherById(teacherId);
    }

    @PatchMapping("/{teacherId}/activate")
    public void activateTeacher(@PathVariable Long teacherId) {
        service.activateTeacherById(teacherId);
    }
}
