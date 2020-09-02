package com.jm.dto;

public class OrderingTaskAnswerDto {

    private String text;
    private Integer position;

    public OrderingTaskAnswerDto(String text, Integer position) {
        this.text = text;
        this.position = position;
    }

    /* GETTERS AND SETTERS */

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
