package com.jm.rest.course;

import com.jm.dto.CourseDto;
import com.jm.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * Get метот, который возврщает CourseDto по Course.id
     * @param courseId
     * @return
     */

    @GetMapping("/{courseId}")
    public CourseDto getCourse(@PathVariable long courseId) {
        return courseRepository.getCourseById(courseId);
    }
}
