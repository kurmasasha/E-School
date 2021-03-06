package com.jm.service.user;

import com.jm.dto.*;
import com.jm.model.Student;
import com.jm.model.StudentGroup;
import com.jm.model.User;

import java.util.List;

public interface GroupService {

    List<CourseDto> getCoursesByDirectionId(Long directionId);

    List<CourseDto> getAllCourses();

    List<GroupPageDto> getGroupsDtoWithSearch(String search);

    List<TeacherForGroupDto> getTeachersByDirectionId(Long directionId);

    List<TeacherForGroupDto> getAllTeachersForGroup();

    List<StudentUserDto> getStudentsInGroup(Long groupId);

    StudentGroup getGroupById(Long groupId);

    Student removeStudentById(Long id);

    StudentGroup updateGroupById(Long groupId, GroupPostDto groupPostDto);

}
