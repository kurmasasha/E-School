package com.jm.dto;

public class TeacherForGroupDto {

    private Long teacherId;
    private String email;
    private String firstName;
    private String lastName;

    public TeacherForGroupDto(Long teacherId, String email, String firstName, String lastName) {
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
}
