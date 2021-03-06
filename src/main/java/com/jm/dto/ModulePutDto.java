package com.jm.dto;

public class ModulePutDto {

    private Long moduleId;
    private String name;
    private String description;

    public ModulePutDto(Long moduleId, String name, String description) {
        this.moduleId = moduleId;
        this.name = name;
        this.description = description;
    }

    /* GETTERS AND SETTERS */

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

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
