package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personal_students_course_tasks")
public class PersonalStudentCourseTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private Boolean isCompleted;
    private Boolean isSolved;

    @ManyToOne
    @JoinColumn(name = "personal_student_course_id")
    private PersonalStudentCourse personalStudentCourse;

    public PersonalStudentCourseTask() {

    }

    public PersonalStudentCourseTask(Task task, Boolean isCompleted, Boolean isSolved, PersonalStudentCourse personalStudentCourse) {
        this.task = task;
        this.isCompleted = isCompleted;
        this.isSolved = isSolved;
        this.personalStudentCourse = personalStudentCourse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public Boolean getSolved() {
        return isSolved;
    }

    public void setSolved(Boolean solved) {
        isSolved = solved;
    }

    public PersonalStudentCourse getPersonalStudentCourse() {
        return personalStudentCourse;
    }

    public void setPersonalStudentCourse(PersonalStudentCourse personalStudentCourse) {
        this.personalStudentCourse = personalStudentCourse;
    }
}
