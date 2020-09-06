package com.jm.rest.admin.student;


import com.jm.dto.ResponseDto;
import com.jm.dto.StudentUserDto;
import com.jm.dto.UserDto;
import com.jm.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/user/student")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseDto<StudentUserDto> getStudentResponse(@RequestParam Integer page,
                                                          @RequestParam String search) {
        return studentService.getStudentResponse(page,search);
    }

    @GetMapping("/{studentId}")
    public UserDto getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public void updateStudent(@RequestBody UserDto updatedStudent, @PathVariable Long studentId) {
        studentService.updateStudent(updatedStudent,studentId);
    }

    @PatchMapping("/{studentId}/activate")
    public void activateStudent(@PathVariable long studentId) {
        studentService.activateStudentById(studentId);
    }

    @PatchMapping("/{studentId}/deactivate")
    public void deactivateStudent(@PathVariable long studentId) {
        studentService.deactivateStudentById(studentId);
    }
}
