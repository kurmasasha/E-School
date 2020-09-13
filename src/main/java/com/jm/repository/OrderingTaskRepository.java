package com.jm.repository;

import com.jm.model.OrderingTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderingTaskRepository extends JpaRepository<OrderingTask, Long> {
}
