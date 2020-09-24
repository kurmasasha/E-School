package com.jm.repository;

import com.jm.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {

    @Query("SELECT new com.jm.model.StudentGroup(group.name, " +
                                                "group.course, " +
                                                "group.teacher, " +
                                                "group.studentList) " +
            "FROM StudentGroup group WHERE group.name = :search")
    List<StudentGroup> getGroupsWithSearch(String search);
  
      /**
     * Возвращает количесвто груп, которые обучаются в определённом курсе
     * @param name
     * @return
     */

    @Query(value = "select count(sg.studentList.size) from StudentGroup sg where sg.course.name = ?1")
    int getGroupCountInCourseName(String name);
}
