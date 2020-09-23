package com.jm.service.course;

import com.jm.dto.*;
import com.jm.model.Course;
import com.jm.repository.CourseRepository;
import com.jm.repository.DirectionRepository;
import com.jm.repository.StudentGroupRepository;
import com.jm.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final DirectionRepository directionRepository;
    private final TeacherRepository teacherRepository;
    private final StudentGroupRepository studentGroupRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, DirectionRepository directionRepository, TeacherRepository teacherRepository, StudentGroupRepository studentGroupRepository) {
        this.courseRepository = courseRepository;
        this.directionRepository = directionRepository;
        this.teacherRepository = teacherRepository;
        this.studentGroupRepository = studentGroupRepository;
    }

    @Override
    public List<CourseDto> getCourses(String search) {
        return search.isEmpty() ? courseRepository.getAllCourse() : courseRepository.findAllCourseByNameLike("%" + search + "%");
    }

    @Override
    public CourseDto getCourseById(long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public boolean delete(long id) {
        courseRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean copy(long id) {
        Course course = courseRepository.findById(id).get();
        Long newId = null;
        course.setId(newId);
        courseRepository.save(course);
        return true;
    }

    @Override
    public boolean isCourseExist(long id) {
        return courseRepository.isCourseExist(id) > 0;
    }

    @Override
    public boolean save(CoursePostDto coursePost) {
        Course course = new Course();
        course.setName(coursePost.getName());
//        course.setDescription(coursePost.);
        course.setHtmlBody(coursePost.getHtmlBody());
        course.setAvailable(coursePost.getAvailable());
        course.setCurator(teacherRepository.findById(coursePost.getCuratorId()).get());
        course.setDirection(directionRepository.findById(coursePost.getDirectionId()).get());
        courseRepository.save(course);
        return true;
    }

    @Override
    public List<CuratorForCourseDto> getCuratorsByDirection_Id(Long directionId) {
        return directionId == null ? courseRepository.findAllCurators() : courseRepository.findAllCuratorByDirection_id(directionId) ;
    }

    @Override
    public List<CoursePageDto> getCoursePageDto(String search) {
        List<CoursePageDto> coursePageDtos = search.isEmpty() ?
                courseRepository.getAllCoursePageDto()
                : courseRepository.getCoursePageDtoLike("%" + search + "%");
        coursePageDtos.forEach(c -> c.setGroupsCount(studentGroupRepository.getGroupCountInCourseName(c.getName())));
        return coursePageDtos;
    }

    @Override
    public boolean save(CoursePutDto coursePut){
        Course course = new Course();
        course.setName(coursePut.getName());
        course.setId(coursePut.getCourseId());
//        course.setDescription(coursePut.);
        course.setHtmlBody(coursePut.getHtmlBody());
        course.setAvailable(coursePut.getAvailable());
        course.setCurator(teacherRepository.findById(coursePut.getCuratorId()).get());
        course.setDirection(directionRepository.findById(coursePut.getDirectionId()).get());
        courseRepository.save(course);
        return true;
    }
}