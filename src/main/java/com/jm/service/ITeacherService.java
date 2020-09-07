package com.jm.service;

import com.jm.dto.TeacherUserDto;
import com.jm.dto.UserDto;
import com.jm.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ITeacherService implements TeacherService {

    private TeacherRepository repository;

    @Autowired
    private void setRepository(TeacherRepository repository) {
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
    public List<TeacherUserDto> getTeacherResponse(Integer page, String search) {
        return repository.getAllTeachers();
    }

    @Override
    public UserDto getTeacherById(Long teacherId) {
        TeacherUserDto tUserDto = repository.getTeacherUserDtoByTeacherId(teacherId);
        return new UserDto(tUserDto.getTeacherId(), tUserDto.getEmail(), tUserDto.getFirstName(), tUserDto.getLastName());
    }

    @Override
    public TeacherUserDto getTeacherUserDtoByTeacherId(Long teacherId) {
        return repository.getTeacherUserDtoByTeacherId(teacherId);
    }
}