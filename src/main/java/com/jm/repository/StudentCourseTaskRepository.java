package com.jm.repository;

import com.jm.model.StudentCourseTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseTaskRepository extends JpaRepository<StudentCourseTask, Long> {
}
