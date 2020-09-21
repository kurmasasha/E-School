package com.jm.service.course;

import com.jm.dto.CourseDto;
import com.jm.dto.CoursePostDto;
import com.jm.dto.CoursePutDto;
import com.jm.dto.CuratorForCourseDto;
import com.jm.model.Course;
import com.jm.model.CourseInfo;
import com.jm.model.Direction;
import com.jm.repository.CourseInfoRepository;
import com.jm.repository.CourseRepository;
import com.jm.repository.DirectionRepository;
import com.jm.repository.TeacherRepository;
import com.jm.service.direction.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final DirectionRepository directionRepository;
    private final CourseInfoRepository courseInfoRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, DirectionRepository directionRepository, CourseInfoRepository courseInfoRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.directionRepository = directionRepository;
        this.courseInfoRepository = courseInfoRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<CourseDto> getCourses(String search) {
        return search.isEmpty() ? courseInfoRepository.getAllCourseInfo() : courseInfoRepository.findAllCourseInfoByCourse_NameLike("%" + search + "%");
    }

    @Override
    public CourseDto getCourseById(long id) {
        return courseInfoRepository.getCourseInfoByCourse_Id(id);
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
        course = courseRepository.save(course);
        CourseInfo courseInfo = courseInfoRepository.findById(id).get();
        courseInfo.setId(null);
        courseInfo.setCourse(course);
        courseInfoRepository.save(courseInfo);
        return true;
    }

    @Override
    public boolean isCourseExist(long id) {
        return courseRepository.isCourseExist(id) > 0;
    }

    @Override
    public boolean save(CoursePostDto coursePost) {
        CourseDto courseDto = new CourseDto(coursePost);
        Course course = new Course(courseDto);
        course.setDirection(directionRepository.findById(courseDto.getDirectionId()).get());
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setCourse(course);
        courseInfo.setAbout(courseDto.getAbout());
        courseInfo.setCurator(teacherRepository.findById(courseDto.getCuratorId()).get());
        courseInfoRepository.save(courseInfo);
        return true;
    }

    @Override
    public List<CuratorForCourseDto> getCuratorsByDirection_Id(Long directionId) {
        return directionId == null ? courseInfoRepository.findAllCurators() : courseInfoRepository.findAllCuratorByDirection_id(directionId) ;
    }

    @Override
    public boolean save(CoursePutDto coursePut){
        CourseDto courseDto = new CourseDto(coursePut);
        Course course = new Course(courseDto);
        course.setDirection(directionRepository.findById(courseDto.getDirectionId()).get());
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setId(courseDto.getCourseId());
        courseInfo.setCourse(course);
        courseInfo.setAbout(courseDto.getAbout());
        courseInfo.setCurator(teacherRepository.findById(courseDto.getCuratorId()).get());
        courseInfoRepository.save(courseInfo);
        return true;
    }
}