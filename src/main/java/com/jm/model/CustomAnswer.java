package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomAnswer {

    @Id
    private Long id;

    private String text;

    public CustomAnswer() {

    }

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
}
