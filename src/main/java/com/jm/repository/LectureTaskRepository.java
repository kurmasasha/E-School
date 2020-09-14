package com.jm.repository;

import com.jm.model.LectureTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureTaskRepository extends JpaRepository<LectureTask, Long> {
}
