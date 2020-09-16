package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class StudentCourseTaskAnswer {

    @Id
    private Long id;

    private String answer;
    private LocalDateTime date;
    private Boolean isRight;

    @OneToOne
    @JoinColumn(name = "custom_answer_id")
    private CustomAnswer customAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_course_task_id")
    private StudentCourseTask studentCourseTask;

    @OneToOne
    @JoinColumn(name = "ordering_task_answer_item_id")
    private OrderingTaskAnswerItem orderingTaskAnswerItem;

    @OneToMany
    private List<StudentCourseTaskAnswer> studentCourseTaskAnswers;

    public StudentCourseTaskAnswer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public CustomAnswer getCustomAnswer() {
        return customAnswer;
    }

    public void setCustomAnswer(CustomAnswer customAnswer) {
        this.customAnswer = customAnswer;
    }

    public StudentCourseTask getStudentCourseTask() {
        return studentCourseTask;
    }

    public void setStudentCourseTask(StudentCourseTask studentCourseTask) {
        this.studentCourseTask = studentCourseTask;
    }

    public OrderingTaskAnswerItem getOrderingTaskAnswerItem() {
        return orderingTaskAnswerItem;
    }

    public void setOrderingTaskAnswerItem(OrderingTaskAnswerItem orderingTaskAnswerItem) {
        this.orderingTaskAnswerItem = orderingTaskAnswerItem;
    }

    public List<StudentCourseTaskAnswer> getStudentCourseTaskAnswers() {
        return studentCourseTaskAnswers;
    }

    public void setStudentCourseTaskAnswers(List<StudentCourseTaskAnswer> studentCourseTaskAnswers) {
        this.studentCourseTaskAnswers = studentCourseTaskAnswers;
    }
}
