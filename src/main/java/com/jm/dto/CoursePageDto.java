package com.jm.dto;

import com.jm.model.Course;

public class CoursePageDto {

    private Long courseId;
    private String name;
    private String directionName;
    private String curatorFullName;
    private Integer groupsCount; //(количество групп, в которых находится курс)
    private Boolean available;

    public CoursePageDto(Long courseId, String name, String directionName, String curatorFirstName,String curatorLastName,
                         Boolean available) {
        this.courseId = courseId;
        this.name = name;
        this.directionName = directionName;
        this.curatorFullName = curatorFirstName + " " + curatorLastName;
//        this.groupsCount = groupsCount;
        this.available = available;
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

    public String getCuratorFullName() {
        return curatorFullName;
    }

    public void setCuratorFullName(String curatorFullName) {
        this.curatorFullName = curatorFullName;
    }

    public Integer getGroupsCount() {
        return groupsCount;
    }

    public void setGroupsCount(Integer groupsCount) {
        this.groupsCount = groupsCount;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
