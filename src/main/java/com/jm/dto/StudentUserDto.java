package com.jm.dto;

import java.util.List;

public class StudentUserDto {

    private Long studentId;
    private String email;
    private String firstName;
    private String lastName;
    private String directionName;
    private List<GroupInfoDto> groups;
    private Boolean enabled;

    /* GETTERS AND SETTERS */

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public List<GroupInfoDto> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupInfoDto> groups) {
        this.groups = groups;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
