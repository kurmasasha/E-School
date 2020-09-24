package com.jm.rest.admin.course;

import com.jm.dto.DirectionDto;
import com.jm.dto.PageDto;
import com.jm.dto.ResponseDto;
import com.jm.service.direction.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/direction")
public class AdminDirectionController {
    private final DirectionService directionService;

    @Autowired
    public AdminDirectionController(DirectionService directionService) {
        this.directionService = directionService;
    }

    /**
     * Get метод, который возвращает лист существующих направлений
     * @return
     */

    @GetMapping
    public ResponseDto<?> getDirection() {
        List<DirectionDto> directions = directionService.getAllDirectionDto();
        PageDto<DirectionDto> page = new PageDto<>(directions.size(),0,0,0,directions);
        return ResponseDto.ok(page);
    }
}
