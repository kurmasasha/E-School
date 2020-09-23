package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TheoryStudentTaskAnswer extends StudentTaskAnswer {

    @OneToOne
    @JoinColumn(name = "possible_student_task_answer_id")
    private PossibleStudentTaskAnswer possibleStudentTaskAnswers;

    public TheoryStudentTaskAnswer() {

    }

    public TheoryStudentTaskAnswer(PossibleStudentTaskAnswer possibleStudentTaskAnswers) {
        this.possibleStudentTaskAnswers = possibleStudentTaskAnswers;
    }

    public PossibleStudentTaskAnswer getPossibleStudentTaskAnswers() {
        return possibleStudentTaskAnswers;
    }

    public void setPossibleStudentTaskAnswers(PossibleStudentTaskAnswer possibleStudentTaskAnswers) {
        this.possibleStudentTaskAnswers = possibleStudentTaskAnswers;
    }
}
