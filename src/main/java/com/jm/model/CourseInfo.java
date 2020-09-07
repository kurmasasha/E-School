package com.jm.model;

import com.jm.dto.CourseInfoDto;

import javax.persistence.*;

@Entity
public class CourseInfo {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private Course course;

    private String description;
    private String about;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher")
    private Teacher curator;

    public CourseInfo() {

    }

    public CourseInfo(CourseInfoDto courseInfoDto) {
        course.setId(courseInfoDto.getCourseId());
        course.setName(courseInfoDto.getName());
        course.getDirection().setName(courseInfoDto.getDirectionName());
        curator.setId(courseInfoDto.getCuratorId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }
}
