package com.jm.dto;

import com.jm.model.Course;
import java.time.LocalDateTime;

public class CourseDto {

    private Long courseId;
    private String name;
    private String description;
    private String htmlBody;
    private Boolean available;
    private LocalDateTime creatingTime;
    private Long curatorId;
    private Long directionId;

    public CourseDto(Long courseId, String name, String description,
                     String htmlBody, Boolean available, LocalDateTime creatingTime, Long curatorId, Long directionId) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.htmlBody = htmlBody;
        this.available = available;
        this.creatingTime = creatingTime;
        this.curatorId = curatorId;
        this.directionId = directionId;
    }

    /* GETTERS AND SETTERS */

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Long directionId) {
        this.directionId = directionId;
    }

    public Long getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(Long curatorId) {
        this.curatorId = curatorId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public LocalDateTime getCreatingTime() {
        return creatingTime;
    }

    public void setCreatingTime(LocalDateTime creatingTime) {
        this.creatingTime = creatingTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
