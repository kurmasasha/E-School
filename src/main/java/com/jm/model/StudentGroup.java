package com.jm.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class StudentGroup {

    @Id
    @Column(name = "id_student_group")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;
//
//    @ManyToOne
//    @JoinColumn(name = "id_course")
//    private CourseInfo courseInfo;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Teacher teacher;

    public StudentGroup() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

//    public CourseInfo getCourseInfo() {
//        return courseInfo;
//    }
//
//    public void setCourseInfo(CourseInfo courseInfo) {
//        this.courseInfo = courseInfo;
//    }

}
