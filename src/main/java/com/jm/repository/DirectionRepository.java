package com.jm.repository;

import com.jm.dto.DirectionDto;
import com.jm.model.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectionRepository extends JpaRepository<Direction, Long> {

    @Query(value = "select new com.jm.dto.DirectionDto(d) from Direction d")
    List<DirectionDto> getAllDirection();
}
