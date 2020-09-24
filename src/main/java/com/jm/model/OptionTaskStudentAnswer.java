package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class OptionTaskStudentAnswer extends StudentTaskAnswer {

    @OneToMany
    private List<OptionStudentTaskAnswerItem> optionStudentTaskAnswerItem;

    public OptionTaskStudentAnswer() {

    }

    public OptionTaskStudentAnswer(List<OptionStudentTaskAnswerItem> optionStudentTaskAnswerItem) {
        this.optionStudentTaskAnswerItem = optionStudentTaskAnswerItem;
    }

    public List<OptionStudentTaskAnswerItem> getOptionStudentTaskAnswerItem() {
        return optionStudentTaskAnswerItem;
    }

    public void setOptionStudentTaskAnswerItem(List<OptionStudentTaskAnswerItem> optionStudentTaskAnswerItem) {
        this.optionStudentTaskAnswerItem = optionStudentTaskAnswerItem;
    }
}
