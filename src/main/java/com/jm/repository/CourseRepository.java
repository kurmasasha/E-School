package com.jm.repository;

import com.jm.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //    Check if the course exists
    @Query(value = "select count(c) from Course c where c.id = ?1")
    Long isCourseExist(long id);

}
