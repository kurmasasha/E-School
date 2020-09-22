package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "possible_student_task_answers")
public class PossibleStudentTaskAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @OneToOne
    @JoinColumn(name = "possible_answer_id")
    private PossibleAnswer possibleAnswer;

    @OneToOne
    @JoinColumn(name = "theory_student_task_answer_id")
    private TheoryStudentTaskAnswer theoryStudentTaskAnswer;

    public PossibleStudentTaskAnswer() {

    }

    public PossibleStudentTaskAnswer(String text, PossibleAnswer possibleAnswer, TheoryStudentTaskAnswer theoryStudentTaskAnswer) {
        this.text = text;
        this.possibleAnswer = possibleAnswer;
        this.theoryStudentTaskAnswer = theoryStudentTaskAnswer;
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

    public PossibleAnswer getPossibleAnswer() {
        return possibleAnswer;
    }

    public void setPossibleAnswer(PossibleAnswer possibleAnswer) {
        this.possibleAnswer = possibleAnswer;
    }

    public TheoryStudentTaskAnswer getTheoryStudentTaskAnswer() {
        return theoryStudentTaskAnswer;
    }

    public void setTheoryStudentTaskAnswer(TheoryStudentTaskAnswer theoryStudentTaskAnswer) {
        this.theoryStudentTaskAnswer = theoryStudentTaskAnswer;
    }
}
