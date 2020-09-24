package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class TheoryTask extends Task {

    @OneToMany(mappedBy = "theoryTask")
    private List<ProbablyAnswer> probablyAnswers;

    public TheoryTask() {
        type = "theory";
    }

    public TheoryTask(List<PossibleAnswer> possibleAnswers) {
        type = "theory";
        this.possibleAnswers = possibleAnswers;
    }
}
