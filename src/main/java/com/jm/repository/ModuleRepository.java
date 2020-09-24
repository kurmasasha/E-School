package com.jm.repository;

import com.jm.dto.ModuleDto;
import com.jm.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    /**
     * Возвращает лист модулей по Course_Id
     * @param id
     * @return
     */

    @Query(value = "select new com.jm.dto.ModuleDto(m.id,m.name,m.description,m.position) from Module m where m.course.id = ?1")
 List<ModuleDto> getModuleByCourse_Id(long id);
}
