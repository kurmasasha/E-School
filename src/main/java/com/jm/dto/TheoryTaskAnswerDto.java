package com.jm.dto;

public class TheoryTaskAnswerDto {

    private Long id;
    private String text;
    private Boolean right;

    public TheoryTaskAnswerDto(Long id, String text, Boolean right) {
        this.id = id;
        this.text = text;
        this.right = right;
    }

    /* GETTERS AND SETTERS */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getRight() {
        return right;
    }

    public void setRight(Boolean right) {
        this.right = right;
    }
}
