package com.jm.service.user;

import com.jm.dto.CourseDto;
import com.jm.model.Course;
import com.jm.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

//    @Override
//    public List<CourseDto> getCourses(String search) {
//        return search.isEmpty() ? courseRepository.findAll() : courseRepository.findByNameLike("%" + search + "%");
//    }

    @Override
    public void delete(long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void copy(long id) {
        courseRepository.save(courseRepository.findById(id).get());
    }

    @Override
    public boolean isCourseExist(long id) {
        return courseRepository.isCourseExist(id) > 0;
    }

    @Override
    public void save(CourseDto course) {
        Course newCourse = new Course(course);
        courseRepository.save(newCourse);
    }
}