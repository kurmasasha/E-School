package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class TheoryTask extends Task {

    @OneToMany
    private List<ProbablyAnswer> probablyAnswers;

    public List<ProbablyAnswer> getProbablyAnswers() {
        return probablyAnswers;
    }

    public void setProbablyAnswers(List<ProbablyAnswer> probablyAnswers) {
        this.probablyAnswers = probablyAnswers;
    }
}
