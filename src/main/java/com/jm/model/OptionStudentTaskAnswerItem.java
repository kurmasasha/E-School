package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "option_student_task_items")
public class OptionStudentTaskAnswerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer position;

    @OneToOne
    private OptionTaskItem optionTaskItem;

    @ManyToOne
    @JoinColumn(name = "option_task_student_answer_id")
    private OptionTaskStudentAnswer optionStudentTaskAnswer;

    public OptionStudentTaskAnswerItem() {

    }

    public OptionStudentTaskAnswerItem(Integer position, OptionTaskItem optionTaskItem, OptionTaskStudentAnswer optionStudentTaskAnswer) {
        this.position = position;
        this.optionTaskItem = optionTaskItem;
        this.optionStudentTaskAnswer = optionStudentTaskAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public OptionTaskItem getOptionTaskItem() {
        return optionTaskItem;
    }

    public void setOptionTaskItem(OptionTaskItem optionTaskItem) {
        this.optionTaskItem = optionTaskItem;
    }

    public OptionTaskStudentAnswer getOptionStudentTaskAnswer() {
        return optionStudentTaskAnswer;
    }

    public void setOptionStudentTaskAnswer(OptionTaskStudentAnswer optionStudentTaskAnswer) {
        this.optionStudentTaskAnswer = optionStudentTaskAnswer;
    }
}
