package com.jm.repository;

import com.jm.dto.TeacherForGroupDto;
import com.jm.dto.TeacherUserDto;
import com.jm.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT new com.jm.dto.TeacherUserDto(u.id, u.email, u.firstName, u.lastName) FROM User u " +
            "WHERE TYPE(u) = Teacher")
    List<TeacherUserDto> getAllTeachers();

    @Query("SELECT new com.jm.dto.TeacherUserDto(u.id, u.email, u.firstName, u.lastName) " +
            "FROM User u " +
            "WHERE CONCAT(u.firstName, u.lastName) LIKE %?1% AND TYPE(u) = Teacher")
    List<TeacherUserDto> getAllBySearch(String search);

    @Query("SELECT new com.jm.dto.TeacherUserDto(u.id, u.email, u.firstName, u.lastName) " +
            "FROM User u " +
            "WHERE u.id = :id AND TYPE(u) = Teacher")
    TeacherUserDto getTeacherUserDtoByTeacherId(@Param("id") Long teacherId);

    @Query("select new com.jm.dto.TeacherForGroupDto(user.id," +
                                                    "user.email, " +
                                                    "user.firstName, " +
                                                    "user.lastName)" +
                                            "from User user WHERE TYPE(user) = Teacher")
    List<TeacherForGroupDto> getAllTeachersForGroupDto();
}