package com.jm.dto;

public class CourseInfoDto {

    private Long courseId;
    private String name;
    private String directionName;
    private Long curatorId;

    public CourseInfoDto(Long courseId, String name, String directionName, Long curatorId) {
        this.courseId = courseId;
        this.name = name;
        this.directionName = directionName;
        this.curatorId = curatorId;
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

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public Long getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(Long curatorId) {
        this.curatorId = curatorId;
    }
}
