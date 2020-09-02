package com.jm.dto;

public class LectureTaskDto {

    private Long taskId;
    private String title;
    private Integer points;
    private String description;

    public LectureTaskDto(Long taskId, String title, Integer points, String description) {
        this.taskId = taskId;
        this.title = title;
        this.points = points;
        this.description = description;
    }

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
}
