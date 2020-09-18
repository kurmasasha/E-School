package com.jm.service.user;

import com.jm.dto.*;
import com.jm.model.StudentGroup;

import java.util.List;

public interface GroupService {

    List<CourseInfoDto> getCoursesByDirectionId(Long directionId);

    List<CourseInfoDto> getAllCourses();

    List<GroupPageDto> getGroupsBySearch(String search);

    List<TeacherForGroupDto> getTeachersByDirectionId(Long directionId);

    List<TeacherForGroupDto> getAllTeachers();

    PageDto<List<StudentUserDto>> getStudentsInGroup(Long groupId);

    StudentGroup getGroupById(Long groupId);

    void removeStudentById(Long id);

    void updateGroupById(Long groupId, GroupPostDto groupPostDto);

}
