package com.jm.model;

import com.jm.dto.OrderingTaskDto;
import com.jm.dto.OrderingTaskItemDto;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderingTask extends Task {

    @OneToMany
    private List<OrderingTaskItem> taskItems;

    public OrderingTask() {
        super();
    }

    public List<OrderingTaskItem> getTaskItems() {
        return taskItems;
    }

    public void setTaskItems(List<OrderingTaskItem> taskItems) {
        this.taskItems = taskItems;
    }
}
