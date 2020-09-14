package com.jm.repository;

import com.jm.model.CustomAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomAnswerRepository extends JpaRepository<CustomAnswer, Long> {
}
