package com.jm.repository;

import com.jm.model.OrderingTaskItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderingTaskItemRepository extends JpaRepository<OrderingTaskItem, Long> {
}
