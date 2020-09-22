package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "option_task_items")
public class OptionTaskItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer position;
    private String itemText;

    @ManyToOne
    @JoinColumn(name = "option_task_id")
    private OptionTask optionTask;

    public OptionTaskItem() {

    }

    public OptionTaskItem(Integer position, String itemText, OptionTask optionTask) {
        this.position = position;
        this.itemText = itemText;
        this.optionTask = optionTask;
    }
}