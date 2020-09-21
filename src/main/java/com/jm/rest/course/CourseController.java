package com.jm.rest.course;

import com.jm.dto.CourseDto;
import com.jm.dto.DirectionDto;
import com.jm.dto.PageDto;
import com.jm.dto.ResponseDto;
import com.jm.repository.CourseInfoRepository;
import com.jm.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseInfoRepository courseInfoRepository;

    @Autowired
    public CourseController(CourseInfoRepository courseInfoRepository) {
        this.courseInfoRepository = courseInfoRepository;
    }

    /**
     * Get метот, который возврщает CourseDto по Course.id
     * @param courseId
     * @return
     */

    @GetMapping("/{courseId}")
    public CourseDto getCourse(@PathVariable long courseId) {
        return courseInfoRepository.getCourseInfoByCourse_Id(courseId);
    }
}
