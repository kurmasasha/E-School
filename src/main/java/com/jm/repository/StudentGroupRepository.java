package com.jm.repository;

import com.jm.dto.GroupPageDto;
import com.jm.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {

    @Query("SELECT new com.jm.dto.GroupPageDto(  group.id, " +
                                                "group.name, " +
                                                "group.course.name, " +
                                                "group.course.direction.name, " +
                                                "CONCAT(group.courseInfo.curator.firstName, group.courseInfo.curator.firstName)," +
                                                "CONCAT(group.teacher.firstName, group.teacher.lastName)," +
                                                "0) " +
            "FROM StudentGroup group WHERE group.name =: search")
    List<GroupPageDto> getGroupsBySearch(String search);

}

//    private Long groupId;
//    private String name;
//    private String courseName;
//    private String directionName;
//    private String curatorFullName; //(lastName + firstName)
//    private String teacherFullName; //(lastName + firstName)
//    private Integer studentsCount;