package com.jm.model;

import com.jm.dto.TheoryTaskDto;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class TheoryTask extends Task {

    @OneToMany
    private List<ProbablyAnswer> probablyAnswers;

    public TheoryTask() {
        super();
    }

    public TheoryTask(TheoryTaskDto theoryTaskDto) {
        this.setId(theoryTaskDto.getTaskId());
        this.setTitle(theoryTaskDto.getTitle());
        this.setPoints(theoryTaskDto.getPoints());
        this.setDescription(theoryTaskDto.getDescription());
        // ??? List<ProbablyAnswer> or List<TheoryTaskAnswerDto>
    }

    public List<ProbablyAnswer> getProbablyAnswers() {
        return probablyAnswers;
    }

    public void setProbablyAnswers(List<ProbablyAnswer> probablyAnswers) {
        this.probablyAnswers = probablyAnswers;
    }
}
