package com.jm.model;

import com.jm.dto.LectureTaskDto;

import javax.persistence.Entity;

@Entity
public class LectureTask extends Task {
    public LectureTask() {
        super();
    }

    public LectureTask(LectureTaskDto lectureTaskDto) {
        this.setId(lectureTaskDto.getTaskId());
        this.setTitle(lectureTaskDto.getTitle());
        this.setPoints(lectureTaskDto.getPoints());
        this.setDescription(lectureTaskDto.getDescription());
    }
}
