package com.jm.dto;

public class ModulePostDto {

    private String name;
    private String description;

    public ModulePostDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /* GETTERS AND SETTERS */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
