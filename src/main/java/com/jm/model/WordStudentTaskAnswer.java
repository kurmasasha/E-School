package com.jm.model;

import javax.persistence.Entity;

@Entity
public class WordStudentTaskAnswer extends StudentTaskAnswer {

    private String answer;

    public WordStudentTaskAnswer() {

    }

    public WordStudentTaskAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
