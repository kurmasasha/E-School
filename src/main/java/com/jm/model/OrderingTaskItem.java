package com.jm.model;

import com.jm.dto.OrderingTaskAnswerDto;

import javax.persistence.*;

@Entity
public class OrderingTaskItem {

    @Id
    @Column(name = "id_ordering_task_item")
    private Long id;

    private Integer position;
    private String itemText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_task")
    private OrderingTask task;

    public OrderingTaskItem() {

    }

    public OrderingTaskItem(OrderingTaskAnswerDto orderingTaskAnswerDto) {
        position = orderingTaskAnswerDto.getPosition();
        itemText = orderingTaskAnswerDto.getText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public OrderingTask getTask() {
        return task;
    }

    public void setTask(OrderingTask task) {
        this.task = task;
    }
}
