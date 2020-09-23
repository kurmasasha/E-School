package com.jm.repository;

import com.jm.dto.CourseDto;
import com.jm.model.Course;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

public interface CourseRepository extends JpaRepository<Course, Long> {

//    Check if the course exists
    @Query(value = "select count(c) from Course c where c.id = ?1")
    Long isCourseExist(long id);

    @Query(value = "select new com.jm.dto.CourseDto(course.id," +
                                                   "course.name," +
                                                   "course.description," +
                                                   "course.htmlBody," +
                                                   "course.isAvailable," +
                                                   "course.creatingTime," +
                                                   "course.curator.id," +
                                                   "course.direction.id) " +
                                            "from Course course " +
                                            "where course.direction.id = :directionId " +
                                            "and course.isAvailable = true ")
    List<CourseDto> findAllWithDirectionId(long directionId);
}