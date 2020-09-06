package com.jm.service;

import com.jm.dto.FieldError;
import com.jm.dto.ResponseDto;
import com.jm.dto.StudentUserDto;
import com.jm.dto.UserDto;
import com.jm.model.User;
import com.jm.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void updateStudent(UserDto updatedStudent, Long studentId) {
        User student = studentRepository.getStudentById(studentId);
        if (Objects.nonNull(student)) {
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());
            student.setId(updatedStudent.getUserId());
            studentRepository.save(student);
        }

    }

    @Override
    public void activateStudentById(Long studentId) {
        User student = studentRepository.getStudentById(studentId);
        student.setEnabled(true);
        studentRepository.save(student);
    }

    @Override
    public void deactivateStudentById(Long studentId) {
        User student = studentRepository.getStudentById(studentId);
        student.setEnabled(false);
        studentRepository.save(student);
    }

    @Override
    public ResponseDto<StudentUserDto> getStudentResponse(Integer page, String search) {
        List<StudentUserDto> students = studentRepository.getAllStudents();
        return new ResponseDto<>(HttpStatus.ACCEPTED, true, search, new ArrayList<FieldError>(), students);
    }

    @Override
    public UserDto getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }
}
