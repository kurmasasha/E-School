package com.jm.dto;

public class CoursePutDto {

    private Long courseId;
    private String name;
    private Long directionId;
    private Long curatorId;
    private Boolean available;
    private String htmlBody;
    private String about;
    private String teacher;

    public CoursePutDto(Long courseId, String name, Long directionId, Long curatorId, Boolean available, String htmlBody, String about, String teacher) {
        this.courseId = courseId;
        this.name = name;
        this.directionId = directionId;
        this.curatorId = curatorId;
        this.available = available;
        this.htmlBody = htmlBody;
        this.about = about;
        this.teacher = teacher;
    }

    /* GETTERS AND SETTERS*/

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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
