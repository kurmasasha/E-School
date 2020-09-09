package com.jm.service;

import com.jm.dto.StudentUserDto;
import com.jm.dto.UserDto;
import com.jm.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean updateStudent(UserDto updatedStudent, Long studentId) {
        StudentUserDto student = studentRepository.getStudentUserDtoByStudentId(studentId);
        if (Objects.nonNull(student)) {
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean activateStudentById(Long studentId) {
        StudentUserDto student = studentRepository.getStudentUserDtoByStudentId(studentId);
        if (Objects.nonNull(student)) {
            student.setEnabled(true);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean deactivateStudentById(Long studentId) {
        StudentUserDto student = studentRepository.getStudentUserDtoByStudentId(studentId);
        if (Objects.nonNull(student)) {
            student.setEnabled(false);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    @Override
    public List<StudentUserDto> getStudentBySearch(String search) {
       return search.isEmpty()? studentRepository.findAll() : studentRepository.findAllBysearch(search);
    }

    @Override
    public StudentUserDto getStudentById(Long studentId) {
        return studentRepository.getStudentUserDtoByStudentId(studentId);
    }
}
