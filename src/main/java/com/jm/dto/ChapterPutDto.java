package com.jm.dto;

public class ChapterPutDto {

    private Long chapterId;
    private String name;

    public ChapterPutDto(Long chapterId, String name) {
        this.chapterId = chapterId;
        this.name = name;
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
}
