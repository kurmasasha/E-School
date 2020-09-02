package com.jm.dto;

public class GroupPageDto {

    private Long groupId;
    private String name;
    private String courseName;
    private String directionName;
    private String curatorFullName; //(lastName + firstName)
    private String teacherFullName; //(lastName + firstName)
    private Integer studentsCount;

    public GroupPageDto(Long groupId, String name, String courseName, String directionName, String curatorFullName,
                        String teacherFullName, Integer studentsCount) {
        this.groupId = groupId;
        this.name = name;
        this.courseName = courseName;
        this.directionName = directionName;
        this.curatorFullName = curatorFullName;
        this.teacherFullName = teacherFullName;
        this.studentsCount = studentsCount;
    }

    /* GETTERS AND SETTERS */

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public String getTeacherFullName() {
        return teacherFullName;
    }

    public void setTeacherFullName(String teacherFullName) {
        this.teacherFullName = teacherFullName;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }
}
