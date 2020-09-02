package com.jm.dto;

public class WordTaskPostDto {

    private String title;
    private Integer points;
    private String description;
    private String answer;

    public WordTaskPostDto(String title, Integer points, String description, String answer) {
        this.title = title;
        this.points = points;
        this.description = description;
        this.answer = answer;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
