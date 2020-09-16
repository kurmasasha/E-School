package com.jm.model;

import com.jm.dto.DirectionDto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Direction {

    @Id
    private Long id;

    private String name;

    public Direction() {

    }

    public Direction(DirectionDto directionDto) {
        id = directionDto.getDirectionId();
        name = directionDto.getName();
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
}
