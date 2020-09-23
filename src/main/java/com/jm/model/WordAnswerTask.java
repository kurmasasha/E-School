package com.jm.model;

import javax.persistence.Entity;

@Entity
public class WordAnswerTask extends Task {

    private String answer;

    public WordAnswerTask() {
        type = "word";
    }

    public WordAnswerTask(String answer) {
        type = "word";
        this.answer = answer;
    }
}