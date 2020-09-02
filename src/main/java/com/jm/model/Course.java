package com.jm.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Course {

    @Id
    @Column(name = "id_course")
    private Long id;

    private String name;
    private String htmlBody;
    private String aboutTeacherInfo;
    private Boolean isAvailable = false;
    private LocalDateTime creatingTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direction")
    private Direction direction;

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public String getAboutTeacherInfo() {
        return aboutTeacherInfo;
    }

    public void setAboutTeacherInfo(String aboutTeacherInfo) {
        this.aboutTeacherInfo = aboutTeacherInfo;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public LocalDateTime getCreatingTime() {
        return creatingTime;
    }

    public void setCreatingTime(LocalDateTime creatingTime) {
        this.creatingTime = creatingTime;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
