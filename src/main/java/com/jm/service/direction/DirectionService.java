package com.jm.service.direction;

import com.jm.dto.DirectionDto;
import com.jm.model.Direction;

import java.util.List;

public interface DirectionService {

    /**
     * Возвращает все направления
     * @return
     */
    List<DirectionDto> getAllDirectionDto();

    /**
     * Возвращает направление по Id
     * @param id
     * @return
     */

    Direction get(long id);
}
