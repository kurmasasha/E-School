package com.jm.dto;

public class LectureTaskPostDto {

    private String title;
    private Integer points;
    private String description;

    public LectureTaskPostDto(String title, Integer points, String description) {
        this.title = title;
        this.points = points;
        this.description = description;
    }

    /* GETTERS AND SETTERS */

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
