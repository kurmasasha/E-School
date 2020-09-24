package com.jm.dto;

public class GroupPostDto {

    private String name;
    private Long courseId;
    private Long teacherId;

    public GroupPostDto(String name, Long courseId, Long teacherId) {
        this.name = name;
        this.courseId = courseId;
        this.teacherId = teacherId;
    }

    /* GETTERS AND SETTERS */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }


}
