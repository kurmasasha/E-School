package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class OrderingTask extends Task {

    @OneToMany
    private List<OrderingTaskItem> taskItems;

    public List<OrderingTaskItem> getTaskItems() {
        return taskItems;
    }

    public void setTaskItems(List<OrderingTaskItem> taskItems) {
        this.taskItems = taskItems;
    }
}
