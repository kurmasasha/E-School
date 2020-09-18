package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderingTaskAnswerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer position;

    @OneToOne
    @JoinColumn(name = "ordering_task_item_id")
    private OrderingTaskItem orderingTaskItem;

    @OneToOne
    @JoinColumn(name = "probably_answer_id")
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
