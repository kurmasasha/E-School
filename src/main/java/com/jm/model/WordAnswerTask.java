package com.jm.model;

import javax.persistence.Entity;

@Entity
public class WordAnswerTask extends Task {
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
