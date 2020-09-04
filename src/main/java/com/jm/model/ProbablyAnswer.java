package com.jm.model;

import javax.persistence.*;

@Entity
@Table(name = "probablyAnswer")
public class ProbablyAnswer {

    @Id
    @Column(name = "id_probably_answer")
    private Long id;

    private String text;
    private Boolean right;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_task")
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