package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class TheoryTask extends Task {

    @OneToMany
    private List<PossibleAnswer> possibleAnswers;

    public TheoryTask() {
        type = "theory";
    }

    public TheoryTask(List<PossibleAnswer> possibleAnswers) {
        type = "theory";
        this.possibleAnswers = possibleAnswers;
    }
}
