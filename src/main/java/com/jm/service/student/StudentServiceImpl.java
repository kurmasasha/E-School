package com.jm.service.student;

import com.jm.dto.StudentUserDto;
import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;
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

    /**
     * Метод апдейта для записи студента.
     * @param updatedStudent
     * @param studentId
     * @return boolean
     */
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

    /**
     * Метод активации записи студента.
     * @param studentId
     * @return boolean
     */
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

    /**
     * Метод деактивации записи студента.
     * @param studentId
     * @return boolean
     */
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

    /**
     * Метод поиска студента.
     * @param search
     * @return List of Students
     */
    @Override
    public List<StudentUserDto> getStudentBySearch(String search) {
       return search.isEmpty()? studentRepository.getAllStudents() : studentRepository.getAllBySearch(search);
    }

    /**
     * Метод получения студента по его id.
     * @param studentId
     * @return StudentUserDto
     */
    @Override
    public StudentUserDto getStudentById(Long studentId) {
        return studentRepository.getStudentUserDtoByStudentId(studentId);
    }

    /**
     * Метод получения студента по его id.
     * @param studentId
     * @return UserDto
     */
    @Override
    public UserDto getStudentByIdDto(Long studentId) {
        StudentUserDto studentUserDto = studentRepository.getStudentUserDtoByStudentId(studentId);
        if (Objects.isNull(studentUserDto)) return new UserDto(0L,"","","");
        return new UserDto(studentUserDto.getStudentId(), studentUserDto.getEmail(),
                studentUserDto.getFirstName(), studentUserDto.getLastName());
    }

    /**
     * Метод добавления студента в бд.
     * @param newStudentDto
     * @return boolean
     */
    @Override
    public boolean saveNewStudent(UserPostDto newStudentDto) {
        Student student = new Student();
        student.setEmail(newStudentDto.getEmail());
        student.setFirstName(newStudentDto.getFirstName());
        student.setLastName(newStudentDto.getLastName());
        student.setEnabled(true);
        studentRepository.save(student);
        return true;
    }
}
