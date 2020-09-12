package com.jm.repository;

import com.jm.model.StudentCourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseInfoRepository extends JpaRepository<StudentCourseInfo, Long> {
}
