package com.jm.model;

import com.jm.dto.CourseDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String htmlBody;
    private String aboutTeacherInfo;
    private Boolean isAvailable = false;
    private LocalDateTime creatingTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "direction_id")
    private Direction direction;

    public Course() {

    }

    public Course(CourseDto courseDto) {
        this.id = courseDto.getCourseId();
        this.name = courseDto.getName();
        this.htmlBody = courseDto.getHtmlBody();
        this.aboutTeacherInfo = courseDto.getTeacher();
        this.isAvailable = courseDto.getAvailable();
//        this.direction.setId(courseDto.getDirectionId());
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
