package com.jm.model;

import com.jm.dto.ModuleDto;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Module {

    @Id
    @Column(name = "id_module")
    private Long id;

    private String name;
    private String description;
    private Integer position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private Course course;

    @Column(name = "is_open")
    private Boolean isOpen = false;

    @Temporal(TemporalType.DATE)
    @Column(name = "open_date")
    private Date openDate;

    public Module() {

    }

    public Module(ModuleDto moduleDto) {
        id = moduleDto.getModuleId();
        name = moduleDto.getName();
        description = moduleDto.getDescription();
        position = moduleDto.getPosition();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
}
