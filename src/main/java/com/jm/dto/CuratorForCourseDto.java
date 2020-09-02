package com.jm.dto;

public class CuratorForCourseDto {

    private Long curatorId;
    private String email;
    private String firstName;
    private String lastName;

    public CuratorForCourseDto(Long curatorId, String email, String firstName, String lastName) {
        this.curatorId = curatorId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /* GETTERS AND SETTERS */

    public Long getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(Long curatorId) {
        this.curatorId = curatorId;
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
}
