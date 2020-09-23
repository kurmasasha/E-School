package com.jm.repository;

import com.jm.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {

    /**
     * Возвращает количесвто груп, которые обучаются в определённом курсе
     * @param name
     * @return
     */

    @Query(value = "select count(sg.studentList.size) from StudentGroup sg where sg.course.name = ?1")
    int getGroupCountInCourseName(String name);
}
