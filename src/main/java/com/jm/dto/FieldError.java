package com.jm.dto;

public class FieldError {

    private String field;
    private String text;

    public FieldError(String field, String text) {
        this.field = field;
        this.text = text;
    }

    /* GETTERS AND SETTERS */

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
