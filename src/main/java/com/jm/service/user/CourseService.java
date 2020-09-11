package com.jm.service.user;

import com.jm.dto.CourseDto;

import java.util.List;

public interface CourseService {
//    List<CourseDto> getCourses(String search);

//    Delete the Course by id
    void delete (long id);
//    Copy the Course by id
    void copy (long id);
//    Check if the course exists
    boolean isCourseExist(long id);
//    Save and Create the Course from CourseDto
    void save(CourseDto course);
}
