package com.jm.service.direction;

import com.jm.dto.DirectionDto;
import com.jm.model.Direction;
import com.jm.repository.DirectionRepository;
import com.jm.service.direction.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DirectionServiceImpl implements DirectionService {
    private final DirectionRepository directionRepository;

    @Autowired
    public DirectionServiceImpl(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    @Override
    public List<DirectionDto> getAllDirectionDto() {
        return directionRepository.findAll().stream().map((Direction d) -> new DirectionDto(d.getId(),d.getName())).collect(Collectors.toList());
    }

    @Override
    public Direction get(long id) {
        return directionRepository.findById(id).get();
    }
}
