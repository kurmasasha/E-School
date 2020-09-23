package com.jm.dto;

import com.jm.model.Direction;

public class DirectionDto {

    private Long directionId;
    private String name;

    public DirectionDto(Long directionId, String name) {
        this.directionId = directionId;
        this.name = name;
    }

    public DirectionDto(Direction direction) {
        this.directionId = direction.getId();
        this.name = direction.getName();
    }

    /* GETTERS AND SETTERS */

    public Long getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Long directionId) {
        this.directionId = directionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
