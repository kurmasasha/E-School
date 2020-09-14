package com.jm.service.student;

import com.jm.dto.StudentUserDto;
import com.jm.dto.UserDto;
import com.jm.model.Student;
import com.jm.repository.StudentRepository;
import com.jm.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final UserService userService;

    public StudentServiceImpl(StudentRepository studentRepository, UserService userService) {
        this.studentRepository = studentRepository;
        this.userService = userService;
    }

    //Update Student data by id and new data
    @Override
    public boolean updateStudent(UserDto updatedStudent, Long studentId) {
        Student student = studentRepository.getOne(studentId);
        if (userService.isUserExist(student.getEmail())) {
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    //Activate Student by Student ID
    @Override
    public boolean activateStudentById(Long studentId) {
        Student student = studentRepository.getOne(studentId);
        if (userService.isUserExist(student.getEmail())) {
            student.setEnabled(true);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    //Deactivate Student by Student ID
    @Override
    public boolean deactivateStudentById(Long studentId) {
        Student student = studentRepository.getOne(studentId);
        if (userService.isUserExist(student.getEmail())) {
            student.setEnabled(false);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    //Search and return Students
    @Override
    public List<StudentUserDto> getStudentBySearch(String search) {
       return search.isEmpty()? studentRepository.getAllStudents() : studentRepository.getAllBySearch(search);
    }

    //Get Student Dto bu Student ID
    @Override
    public StudentUserDto getStudentById(Long studentId) {
        return studentRepository.getStudentUserDtoByStudentId(studentId);
    }

    //Get Student as User Dto by Stundet ID
    @Override
    public UserDto getStudentByIdDto(Long teacherId) {
        StudentUserDto studentUserDto = studentRepository.getStudentUserDtoByStudentId(teacherId);
        return new UserDto(studentUserDto.getStudentId(), studentUserDto.getEmail(),
                studentUserDto.getFirstName(), studentUserDto.getLastName());
    }

    //Create new Student and save to DB
    @Override
    public boolean saveNewStudent(UserDto newStudentDto) {
        Student student = new Student();
        student.setId(newStudentDto.getUserId());
        student.setEmail(newStudentDto.getEmail());
        student.setFirstName(newStudentDto.getFirstName());
        student.setLastName(newStudentDto.getLastName());
        student.setEnabled(true);
        studentRepository.save(student);
        return true;
    }
}
