package com.jm.dto;

public class ChapterDto {

    private Long chapterId;
    private String name;
    private Integer position;

    public ChapterDto(Long chapterId, String name, Integer position) {
        this.chapterId = chapterId;
        this.name = name;
        this.position = position;
    }

    /* GETTERS AND SETTERS */

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
