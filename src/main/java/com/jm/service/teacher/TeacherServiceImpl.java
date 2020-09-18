package com.jm.service.teacher;

import com.jm.dto.TeacherUserDto;
import com.jm.dto.UserDto;
import com.jm.dto.UserPostDto;
import com.jm.model.Teacher;
import com.jm.repository.TeacherRepository;
import com.jm.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;
    private final UserService userService;

    public TeacherServiceImpl(TeacherRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    /**
     * Метод апдейта для записи преподавателя.
     * @param editedTeacherInfo
     * @param teacherId
     * @return
     */
    @Override
    public boolean updateTeacherInfo(UserDto editedTeacherInfo, Long teacherId) {
        Teacher teacher = repository.getOne(teacherId);
        if (userService.isUserExist(teacher.getEmail())) {
            teacher.setEmail(editedTeacherInfo.getEmail());
            teacher.setFirstName(editedTeacherInfo.getFirstName());
            teacher.setLastName(editedTeacherInfo.getLastName());
            repository.save(teacher);
            return true;
        }
        return false;
    }

    /**
     * Метод деактивации записи пользователя.
     * @param teacherId
     * @return
     */
    @Override
    public boolean deactivateTeacherById(Long teacherId) {
        Teacher teacher = repository.getOne(teacherId);
        if (userService.isUserExist(teacher.getEmail())) {
            teacher.setEnabled(false);
            repository.save(teacher);
            return true;
        }
        return false;
    }

    /**
     * Метод активации записи пользователя.
     * @param teacherId
     * @return
     */
    @Override
    public boolean activateTeacherById(Long teacherId) {
        Teacher teacher = repository.getOne(teacherId);
        if (userService.isUserExist(teacher.getEmail())) {
            teacher.setEnabled(true);
            repository.save(teacher);
            return true;
        }
        return false;
    }

    /**
     * Метод поиска.
     * @param search
     * @return
     */
    @Override
    public List<TeacherUserDto> getTeachersBySearch(String search) {
        if (search.isEmpty()) {
            return repository.getAllTeachers();
        } else {
            return repository.getAllBySearch(search);
        }
    }

    /**
     * Метод получения преподавателя по его id.
     * @param teacherId
     * @return
     */
    @Override
    public UserDto getTeacherById(Long teacherId) {
        TeacherUserDto teacherUserDto = repository.getTeacherUserDtoByTeacherId(teacherId);
        return new UserDto(teacherUserDto.getTeacherId(), teacherUserDto.getEmail(),
                teacherUserDto.getFirstName(), teacherUserDto.getLastName());
    }

    /**
     * Метод получения TeacherUserDto по id преподавателя.
     * @param teacherId
     * @return
     */
    @Override
    public TeacherUserDto getTeacherUserDtoByTeacherId(Long teacherId) {
        return repository.getTeacherUserDtoByTeacherId(teacherId);
    }

    /**
     * Метод добавления преподавателя в бд.
     * @param newTeacher
     * @return
     */
    @Override
    public boolean saveNewTeacher(UserPostDto newTeacher) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(newTeacher.getFirstName());
        teacher.setLastName(newTeacher.getLastName());
        teacher.setEmail(newTeacher.getEmail());
        teacher.setEnabled(true);
        repository.save(teacher);
        return true;
    }
}