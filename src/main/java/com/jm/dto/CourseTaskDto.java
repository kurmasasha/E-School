package com.jm.dto;

public class CourseTaskDto {

    private Long courseTaskId;
    private Long taskId;
    private String taskTitle;
    private Integer courseTaskPosition;
    private String taskType;

    public CourseTaskDto(Long courseTaskId, Long taskId, String taskTitle, Integer courseTaskPosition, String taskType) {
        this.courseTaskId = courseTaskId;
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.courseTaskPosition = courseTaskPosition;
        this.taskType = taskType;
    }

    /* GETTERS AND SETTERS */

    public Long getCourseTaskId() {
        return courseTaskId;
    }

    public void setCourseTaskId(Long courseTaskId) {
        this.courseTaskId = courseTaskId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Integer getCourseTaskPosition() {
        return courseTaskPosition;
    }

    public void setCourseTaskPosition(Integer courseTaskPosition) {
        this.courseTaskPosition = courseTaskPosition;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
