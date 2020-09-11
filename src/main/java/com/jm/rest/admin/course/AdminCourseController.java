package com.jm.rest.admin.course;

import com.jm.dto.*;
import com.jm.service.user.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/course")
public class AdminCourseController {

    private final CourseService courseService;

    @Autowired
    public AdminCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

//    @GetMapping
//    public ResponseDto<CoursePageDto> getCourseByName(@RequestParam Integer page,
//                                                   @RequestParam String search){
//        List<FieldError> errors = new ArrayList<>();
//        List<CoursePageDto> coursePages = courseService;
//        PageDto<CoursePageDto> pageDto = new PageDto<>(coursePages.size(),page,0,0,coursePages);
//        System.out.println(page + " " + search);
//        return new ResponseDto<>(HttpStatus.OK.value(), true, "Success", errors, pageDto);
//    }

    @DeleteMapping("/{courseId}")
        public void deleteCourse(@PathVariable long courseId){
        courseService.delete(courseId);
    }

    @PostMapping("/{courseId}/copy")
    public void copyCourse(@PathVariable long courseId){
        courseService.copy(courseId);
    }

    @PutMapping("/{courseId}")
    public void updateCourse(@PathVariable long courseId, @RequestBody CourseDto course) {
        if (courseService.isCourseExist(courseId)) {
            course.setCourseId(courseId);
            courseService.save(course);
        }
    }

    @PostMapping("/{courseId}")
    public void createCourse(@PathVariable long courseId, @RequestBody CourseDto course){
        courseService.save(course);
    }
}
