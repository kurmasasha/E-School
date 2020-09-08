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
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void updateStudent(UserDto updatedStudent, Long studentId) {
        Optional<User> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            student.get().setFirstName(updatedStudent.getFirstName());
            student.get().setLastName(updatedStudent.getLastName());
            student.get().setEmail(updatedStudent.getEmail());
            student.get().setId(updatedStudent.getUserId());
            studentRepository.save(student.get());
        }

    }

    @Override
    public void activateStudentById(Long studentId) {
        Optional<User> student = studentRepository.findById(studentId);
        student.ifPresent(user -> user.setEnabled(true));
        studentRepository.save(student.get());
    }

    @Override
    public void deactivateStudentById(Long studentId) {
        Optional<User> student = studentRepository.findById(studentId);
        student.ifPresent(user -> user.setEnabled(false));
        studentRepository.save(student.get());
    }

    @Override
    public ResponseDto<StudentUserDto> getStudentResponse(Integer page, String search) {
        List<User> students = studentRepository.findAll();
        return new ResponseDto<>(HttpStatus.ACCEPTED, true, search, new ArrayList<FieldError>(), students);
    }

    @Override
    public UserDto getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }
}
