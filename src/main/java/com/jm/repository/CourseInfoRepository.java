package com.jm.repository;

import com.jm.dto.CourseInfoDto;
import com.jm.model.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseInfoRepository extends JpaRepository<CourseInfo, Long> {

    @Query("SELECT new com.jm.dto.CourseInfoDto( courseInfoDto.course.id, " +
                                                "courseInfoDto.course.name, " +
                                                "courseInfoDto.course.direction.name, " +
                                                "courseInfoDto.curator.id) " +
                    "FROM CourseInfo courseInfoDto " +
                    "WHERE courseInfoDto.course.direction.id = :directionId " +
                    "AND courseInfoDto.course.isAvailable = true")
    List<CourseInfoDto> findAllByDirectionId(Long directionId);

}
