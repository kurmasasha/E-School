package com.jm.dto;

import java.util.List;

public class TheoryTaskDto {

    private Long taskId;
    private String title;
    private Integer points;
    private String description;
    private List<TheoryTaskAnswerDto> answers;

    /* GETTERS AND SETTERS */

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TheoryTaskAnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<TheoryTaskAnswerDto> answers) {
        this.answers = answers;
    }
}
