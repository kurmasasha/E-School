package com.jm.dto;

public class OrderingTaskItemDto {

    private Long itemId;
    private String text;
    private Integer position;

    public OrderingTaskItemDto(Long itemId, String text, Integer position) {
        this.itemId = itemId;
        this.text = text;
        this.position = position;
    }

    /* GETTERS AND SETTERS */

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

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
