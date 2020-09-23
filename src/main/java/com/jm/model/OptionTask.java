package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class OptionTask extends Task {

    @OneToMany
    private List<OptionTaskItem> taskItems;

    public OptionTask() {
        type = "option";
    }

    public OptionTask(List<OptionTaskItem> taskItems) {
        type = "option";
        this.taskItems = taskItems;
    }
}