package com.jm.model;

import javax.persistence.*;

@Entity
public class OrderingTaskAnswerItem {

    @Id
    @Column(name = "id_ordering_task_answer_item")
    private Long id;

    private Integer position;

    @OneToOne
    @JoinColumn(name = "id_ordering_task_item")
    private OrderingTaskItem orderingTaskItem;

    @OneToOne
    @JoinColumn(name = "id_probably_answer")
    private ProbablyAnswer probablyAnswer;

    @OneToOne(fetch = FetchType.LAZY)
    private StudentCourseTaskAnswer studentCourseTaskAnswer;

    public OrderingTaskAnswerItem() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public OrderingTaskItem getOrderingTaskItem() {
        return orderingTaskItem;
    }

    public void setOrderingTaskItem(OrderingTaskItem orderingTaskItem) {
        this.orderingTaskItem = orderingTaskItem;
    }

    public ProbablyAnswer getProbablyAnswer() {
        return probablyAnswer;
    }

    public void setProbablyAnswer(ProbablyAnswer probablyAnswer) {
        this.probablyAnswer = probablyAnswer;
    }

    public StudentCourseTaskAnswer getStudentCourseTaskAnswer() {
        return studentCourseTaskAnswer;
    }

    public void setStudentCourseTaskAnswer(StudentCourseTaskAnswer studentCourseTaskAnswer) {
        this.studentCourseTaskAnswer = studentCourseTaskAnswer;
    }
}
