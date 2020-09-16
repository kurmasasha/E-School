package com.jm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "probably_answer")
public class ProbablyAnswer {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String text;

    @Column(name = "is_right")
    private Boolean right;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theory_task_id")
    private TheoryTask theoryTask;

    public ProbablyAnswer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getRight() {
        return right;
    }

    public void setRight(Boolean right) {
        this.right = right;
    }

    public TheoryTask getTheoryTask() {
        return theoryTask;
    }

    public void setTheoryTask(TheoryTask theoryTask) {
        this.theoryTask = theoryTask;
    }
}
