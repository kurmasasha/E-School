package com.jm.service.module;

import com.jm.dto.ModuleDto;
import com.jm.dto.ModulePostDto;

import java.util.List;

public interface ModuleService {

    /**
     * Возвращает все модулия связанные с курсом по id
     * @param id
     * @return
     */

    List<ModuleDto> getModuleByCourse_Id(long id);

    /**
     * Сохраняет модуль
     * @param module
     * @return
     */

    boolean save(ModulePostDto module);
}
