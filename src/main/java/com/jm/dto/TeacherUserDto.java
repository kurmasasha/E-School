package com.jm.dto;

import java.util.List;

public class TeacherUserDto {

    private Long teacherId;
    private String email;
    private String firstName;
    private String lastName;
    private String directionName;
    private Boolean isCurator;
    private List<GroupInfoDto> groups;
    private List<CourseInfoDto> courses;
    private Boolean enabled;

    public TeacherUserDto(Long teacherId, String email, String firstName, String lastName, String directionName,
                          Boolean isCurator, List<GroupInfoDto> groups, List<CourseInfoDto> courses, Boolean enabled) {
        this(teacherId, email, firstName, lastName);
        this.directionName = directionName;
        this.isCurator = isCurator;
        this.groups = groups;
        this.courses = courses;
        this.enabled = enabled;
    }

    public TeacherUserDto(Long teacherId, String email, String firstName, String lastName) {
        this.teacherId = teacherId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /* GETTERS AND SETTERS */

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public Boolean getCurator() {
        return isCurator;
    }

    public void setCurator(Boolean curator) {
        isCurator = curator;
    }

    public List<GroupInfoDto> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupInfoDto> groups) {
        this.groups = groups;
    }

    public List<CourseInfoDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseInfoDto> courses) {
        this.courses = courses;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
