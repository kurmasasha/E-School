package com.jm.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class StudentCourseInfo {

    @Id
    @Column(name = "id_student_course_info")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User student;

    private Date addingDate;
    private Boolean isCompleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private Course course;

    @OneToMany
    private List<StudentCourseTask> studentCourseTasks;

    public StudentCourseInfo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<StudentCourseTask> getStudentCourseTasks() {
        return studentCourseTasks;
    }

    public void setStudentCourseTasks(List<StudentCourseTask> studentCourseTasks) {
        this.studentCourseTasks = studentCourseTasks;
    }
}
