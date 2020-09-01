package com.jm.dto;

import java.util.List;

public class OrderingTaskPostDto {

    private String title;
    private Integer points;
    private String description;
    private List<OrderingTaskAnswerDto> items;

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

    public List<OrderingTaskAnswerDto> getItems() {
        return items;
    }

    public void setItems(List<OrderingTaskAnswerDto> items) {
        this.items = items;
    }
}
