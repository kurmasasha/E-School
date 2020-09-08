package com.jm.service;

import com.jm.dto.TeacherUserDto;
import com.jm.dto.UserDto;
import com.jm.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean updateTeacherInfo(UserDto editedTeacherInfo, Long teacherId) {
        TeacherUserDto teacher = repository.getTeacherUserDtoByTeacherId(teacherId);
        if (Objects.nonNull(teacher)) {
            teacher.setEmail(editedTeacherInfo.getEmail());
            teacher.setFirstName(editedTeacherInfo.getFirstName());
            teacher.setLastName(editedTeacherInfo.getLastName());
            repository.save(teacher);
            return true;
        }
        return false;
    }

    @Override
    public boolean deactivateTeacherById(Long teacherId) {
        TeacherUserDto teacher = repository.getTeacherUserDtoByTeacherId(teacherId);
        if (Objects.nonNull(teacher)) {
            teacher.setEnabled(false);
            repository.save(teacher);
            return true;
        }
        return false;
    }

    @Override
    public boolean activateTeacherById(Long teacherId) {
        TeacherUserDto teacher = repository.getTeacherUserDtoByTeacherId(teacherId);
        if (Objects.nonNull(teacher)) {
            teacher.setEnabled(true);
            repository.save(teacher);
            return true;
        }
        return false;
    }

    @Override
    public List<TeacherUserDto> getTeachersBySearch(String search) {
        if (search.isEmpty()) {
            return repository.getAllTeachers();
        } else {
            return repository.getAllBySearch(search);
        }
    }

    @Override
    public UserDto getTeacherById(Long teacherId) {
        TeacherUserDto teacherUserDto = repository.getTeacherUserDtoByTeacherId(teacherId);
        return new UserDto(teacherUserDto.getTeacherId(), teacherUserDto.getEmail(),
                teacherUserDto.getFirstName(), teacherUserDto.getLastName());
    }

    @Override
    public TeacherUserDto getTeacherUserDtoByTeacherId(Long teacherId) {
        return repository.getTeacherUserDtoByTeacherId(teacherId);
    }
}