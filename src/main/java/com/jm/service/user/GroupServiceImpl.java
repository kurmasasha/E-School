package com.jm.service.user;

import com.jm.dto.*;
import com.jm.model.*;
import com.jm.repository.CourseRepository;
import com.jm.repository.StudentGroupRepository;
import com.jm.repository.TeacherRepository;
import com.jm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {

    private final StudentGroupRepository groupRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final List<TeacherForGroupDto> teacherForGroupDtoList = new ArrayList<>();
    private final List<GroupPageDto> groupPageDtoList = new ArrayList<>();
    private List<CourseDto> courseDtoList = new ArrayList<>();

    @Autowired
    public GroupServiceImpl(StudentGroupRepository groupRepository, TeacherRepository teacherRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CourseDto> getCoursesByDirectionId(Long directionId) {
        courseDtoList = courseRepository.findAllWithDirectionId(directionId);
        return courseDtoList;
    }

    @Override
    public List<CourseDto> getAllCourses() {

        courseDtoList.clear();
        List<Course> courseList = courseRepository.findAll();
        for (Course i : courseList) {
            CourseDto currentDto = new CourseDto(i.getId(),
                                                 i.getName(),
                                                 i.getDescription(),
                                                 i.getHtmlBody(),
                                                 i.getAvailable(),
                                                 i.getCreatingTime(),
                                                 i.getCurator().getId(),
                                                 i.getDirection().getId());
            courseDtoList.add(currentDto);
        }
        return courseDtoList;
    }

    @Override
    public List<GroupPageDto> getGroupsDtoWithSearch(String search) {

        groupPageDtoList.clear();
        List<StudentGroup> groups = groupRepository.getGroupsWithSearch(search);
        for (StudentGroup i : groups){
            GroupPageDto pageDto = new GroupPageDto(i.getId(),
                                                    i.getName(),
                                                    i.getCourse().getName(),
                                                    i.getCourse().getDirection().getName(),
                                                    i.getCourse().getCurator().getFirstName() + i.getCourse().getCurator().getLastName(),
                                                    i.getTeacher().getFirstName() + i.getTeacher().getLastName(),
                                                    i.getStudentList().size());
            groupPageDtoList.add(pageDto);
        }
        return groupPageDtoList;
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

        Set<TeacherForGroupDto> teacherSet = new HashSet<>();
        List<StudentGroup> allGroups = groupRepository.findAll();

        for (StudentGroup i : allGroups) {
            if (i.getCourse().getDirection().getId().equals(directionId)) {
                teacherSet.add(new TeacherForGroupDto(i.getTeacher().getId(),
                                                      i.getTeacher().getEmail(),
                                                      i.getTeacher().getFirstName(),
                                                      i.getTeacher().getLastName()));
            }

        }
        teacherForGroupDtoList.clear();
        teacherForGroupDtoList.addAll(teacherSet);

        return teacherForGroupDtoList;
    }

    @Override
    public List<StudentUserDto> getStudentsInGroup(Long groupId) {

        List<StudentUserDto> studentsDto = new ArrayList<>();
        StudentGroup group = groupRepository.findById(groupId).get();
        List<Student> students = group.getStudentList();

        for (Student i : students) {
            if (i.getEnabled()) {
                studentsDto.add(new StudentUserDto(i.getId(),
                                                   i.getEmail(),
                                                   i.getFirstName(),
                                                   i.getLastName(),
                                                   group.getCourse().getDirection().getName(),
                                                   group.getName(),
                                                   i.getEnabled()));
            }
        }
        return studentsDto;
    }

    @Override
    public StudentGroup getGroupById(Long groupId){
        return groupRepository.findById(groupId).get();
    }

    @Override
    public User removeStudentById(Long id) {
        User student = userRepository.findById(id).get();
        student.setEnabled(false);
        return student;
    }

    @Override
    @Transactional
    public StudentGroup updateGroupById(Long groupId, GroupPostDto groupPostDto) {
        StudentGroup group = groupRepository.findById(groupId).get();
        group.setName(groupPostDto.getName());
        group.setCourse(courseRepository.getOne(groupPostDto.getCourseId()));
        group.setTeacher(teacherRepository.getOne(groupPostDto.getTeacherId()));
        return group;
    }
}
