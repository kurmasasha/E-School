package com.jm.model;

import com.jm.dto.CourseTaskDto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CourseTask {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    private Integer position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    public CourseTask() {

    }

    public CourseTask(CourseTaskDto courseTaskDto) {
        this.id = courseTaskDto.getCourseTaskId();
        this.task.setId(courseTaskDto.getTaskId());
        this.position = courseTaskDto.getCourseTaskPosition();
        this.task.setTitle(courseTaskDto.getTaskTitle());
        this.task.setType(courseTaskDto.getTaskType());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
