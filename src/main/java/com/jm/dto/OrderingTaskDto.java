package com.jm.dto;

import java.util.List;

public class OrderingTaskDto {

    private Long taskId;
    private String title;
    private Integer points;
    private String description;
    private List<OrderingTaskItemDto> items;

    public OrderingTaskDto(Long taskId, String title, Integer points, String description, List<OrderingTaskItemDto> items) {
        this.taskId = taskId;
        this.title = title;
        this.points = points;
        this.description = description;
        this.items = items;
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

    public List<OrderingTaskItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderingTaskItemDto> items) {
        this.items = items;
    }
}
