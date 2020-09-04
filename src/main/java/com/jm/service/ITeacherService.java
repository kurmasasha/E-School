package com.jm.service;

import com.jm.dto.*;
import com.jm.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ITeacherService implements TeacherService {

    private TeacherRepository repository;

    @Autowired
    private void setRepository(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public void updateTeacherInfo(UserDto editedTeacherInfo, Long teacherId) {
        User teacher = repository.getTeacherById(teacherId);
        if (teacher != null) {
            repository.save(editedTeacherInfo);
        }
    }

    @Override
    public void deactivateTeacherById(Long teacherId) {
        User teacher = repository.getTeacherById(teacherId);
        teacher.setEnabled(false);
        repository.save(teacher);
    }

    @Override
    public void activateTeacherById(Long teacherId) {
        User teacher = repository.getTeacherById(teacherId);
        teacher.setEnabled(true);
        repository.save(teacher);
    }

    @Override
    public ResponseDto<TeacherUserDto> getTeacherResponse(Integer page, String search) {
        List<TeacherUserDto> teachers = repository.getAllTeachers();
        // dummy FieldError, for now
        List<FieldError> errors = new ArrayList<>();
        // pageCount and countOn page are 0, for now
        PageDto<TeacherUserDto> pageDto = new PageDto<>(teachers.size(), page, 0, 0, teachers);
        return new ResponseDto<>(200, true, search, errors, pageDto);
    }

    @Override
    public UserDto getTeacherById(Long teacherId) {
        return repository.getTeacherById(teacherId);
    }
}
