package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_task_answers")
public class StudentTaskAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private Boolean isRight;

    @ManyToOne
    @JoinColumn(name = "personal_student_course_task_id")
    private PersonalStudentCourseTask personalStudentCourseTask;

    public StudentTaskAnswer() {

    }

    public StudentTaskAnswer(LocalDateTime date, Boolean isRight, PersonalStudentCourseTask personalStudentCourseTask) {
        this.date = date;
        this.isRight = isRight;
        this.personalStudentCourseTask = personalStudentCourseTask;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getRight() {
        return isRight;
    }

    public void setRight(Boolean right) {
        isRight = right;
    }

    public PersonalStudentCourseTask getPersonalStudentCourseTask() {
        return personalStudentCourseTask;
    }

    public void setPersonalStudentCourseTask(PersonalStudentCourseTask personalStudentCourseTask) {
        this.personalStudentCourseTask = personalStudentCourseTask;
    }
}