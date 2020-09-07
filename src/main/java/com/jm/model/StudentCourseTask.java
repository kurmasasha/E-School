package com.jm.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class StudentCourseTask {

    @Id
    @Column(name = "id_student_course_task")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course_task")
    private CourseTask courseTask;

    private Boolean isRight;
    private Boolean isWrong;
    private Boolean isReset;
    private Boolean isSolved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student_course_info")
    private StudentCourseInfo studentCourseInfo;

    @OneToMany
    private List<StudentCourseTaskAnswer> studentCourseTaskAnswers;

    public StudentCourseTask() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourseTask getCourseTask() {
        return courseTask;
    }

    public void setCourseTask(CourseTask courseTask) {
        this.courseTask = courseTask;
    }

    public Boolean getRight() {
        return isRight;
    }

    public void setRight(Boolean right) {
        isRight = right;
    }

    public Boolean getWrong() {
        return isWrong;
    }

    public void setWrong(Boolean wrong) {
        isWrong = wrong;
    }

    public Boolean getReset() {
        return isReset;
    }

    public void setReset(Boolean reset) {
        isReset = reset;
    }

    public Boolean getSolved() {
        return isSolved;
    }

    public void setSolved(Boolean solved) {
        isSolved = solved;
    }

    public StudentCourseInfo getStudentCourseInfo() {
        return studentCourseInfo;
    }

    public void setStudentCourseInfo(StudentCourseInfo studentCourseInfo) {
        this.studentCourseInfo = studentCourseInfo;
    }

    public List<StudentCourseTaskAnswer> getStudentCourseTaskAnswers() {
        return studentCourseTaskAnswers;
    }

    public void setStudentCourseTaskAnswers(List<StudentCourseTaskAnswer> studentCourseTaskAnswers) {
        this.studentCourseTaskAnswers = studentCourseTaskAnswers;
    }
}
