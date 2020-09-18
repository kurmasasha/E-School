package com.jm.service.user;

import com.jm.dto.*;
import com.jm.model.CourseInfo;
import com.jm.model.StudentGroup;
import com.jm.model.Teacher;
import com.jm.repository.CourseInfoRepository;
import com.jm.repository.StudentGroupRepository;
import com.jm.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final StudentGroupRepository groupRepository;
    private final CourseInfoRepository courseInfoRepository;
    private final TeacherRepository teacherRepository;
    private List<CourseInfoDto> courseInfoDtoList = new ArrayList<>();
    private List<TeacherForGroupDto> teacherForGroupDtoList = new ArrayList<>();

    @Autowired
    public GroupServiceImpl(StudentGroupRepository groupRepository, CourseInfoRepository courseInfoRepository, TeacherRepository teacherRepository) {
        this.groupRepository = groupRepository;
        this.courseInfoRepository = courseInfoRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<CourseInfoDto> getCoursesByDirectionId(Long directionId) {
        courseInfoDtoList = courseInfoRepository.findAllByDirectionId(directionId);
        return courseInfoDtoList;
    }

    @Override
    public List<CourseInfoDto> getAllCourses() {

        courseInfoDtoList.clear();
        List<CourseInfo> courseInfoList = courseInfoRepository.findAll();

        for (CourseInfo i : courseInfoList) {
            CourseInfoDto currentDto = new CourseInfoDto(i.getCourse().getId(),
                                                         i.getCourse().getName(),
                                                         i.getCourse().getDirection().getName(),
                                                         i.getCurator().getId());
            courseInfoDtoList.add(currentDto);
        }

        return courseInfoDtoList;
    }

    @Override
    public List<GroupPageDto> getGroupsBySearch(String search) {

        return groupRepository.getGroupsBySearch(search);
    }

    @Override
    public List<TeacherForGroupDto> getAllTeachers() {

        teacherForGroupDtoList.clear();
        List<Teacher> teachers = teacherRepository.findAll();

        for (Teacher i : teachers) {
            TeacherForGroupDto currentDto = new TeacherForGroupDto(i.getId(),
                                                                   i.getEmail(),
                                                                   i.getFirstName(),
                                                                   i.getLastName());
            teacherForGroupDtoList.add(currentDto);
        }

        return teacherForGroupDtoList;
    }

    @Override
    public List<TeacherForGroupDto> getTeachersByDirectionId(Long directionId) {
        teacherForGroupDtoList = teacherRepository.findAllByDirectionId(directionId);
        return teacherForGroupDtoList;
    }

    @Override
    public PageDto<List<StudentUserDto>> getStudentsInGroup(Long groupId) {
        return null;
    }

    @Override
    public StudentGroup getGroupById(Long groupId){return null;}

    @Override
    public void removeStudentById(Long id) {

    }

    @Override
    public void updateGroupById(Long groupId, GroupPostDto groupPostDto) {

    }
}
