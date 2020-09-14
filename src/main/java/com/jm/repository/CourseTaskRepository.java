package com.jm.repository;

import com.jm.model.CourseTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTaskRepository extends JpaRepository<CourseTask, Long> {
}
