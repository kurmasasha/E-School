package com.jm.dto;

public class StudentUserDto {

    private Long studentId;
    private String email;
    private String firstName;
    private String lastName;
    private String directionName;
    private Boolean enabled;
    private Long groupId;

    public StudentUserDto(Long studentId, String email, String firstName, String lastName, String directionName,
                          Long groupId, Boolean enabled) {
        this.studentId = studentId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.directionName = directionName;
        this.groupId = groupId;
        this.enabled = enabled;
    }

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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
