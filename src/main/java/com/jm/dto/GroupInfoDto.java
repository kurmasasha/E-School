package com.jm.dto;

public class GroupInfoDto {

    private Long groupId;
    private String name;
    private Long teacherId;

    public GroupInfoDto(Long groupId, String name, Long teacherId) {
        this.groupId = groupId;
        this.name = name;
        this.teacherId = teacherId;
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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
