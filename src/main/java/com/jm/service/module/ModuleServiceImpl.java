package com.jm.service.module;

import com.jm.dto.ModuleDto;
import com.jm.dto.ModulePostDto;
import com.jm.model.Module;
import com.jm.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    @Autowired
    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public List<ModuleDto> getModuleByCourse_Id(long id) {
        return moduleRepository.getModuleByCourse_Id(id);
    }

    @Override
    public boolean save(ModulePostDto modulePost) {
        ModuleDto moduleDto = new ModuleDto(null, modulePost.getName()
                , modulePost.getDescription(), null);
        moduleRepository.save(new Module(moduleDto));
        return true;
    }
}
