package com.jm.rest.admin.course;

import com.jm.dto.*;
import com.jm.service.course.CourseService;
import com.jm.service.module.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/course")
public class AdminCourseController {

    private final CourseService courseService;
    private final ModuleService moduleService;

    @Autowired
    public AdminCourseController(CourseService courseService, ModuleService moduleService) {
        this.courseService = courseService;
        this.moduleService = moduleService;
    }

    /**
     * Get метод, возвращает все курсы в виде лист CoursePage, если передан параметр search
     * , то только курсы в имени которых содержится эта строка
     * @param page
     * @param search
     * @return
     */

    @GetMapping
    public ResponseDto<?> getCoursePageDto(@RequestParam Integer page,
                                           @RequestParam(required = false) String search){
        List<CoursePageDto> coursePages = courseService.getCoursePageDto(search);
        PageDto<CoursePageDto> pageDto = new PageDto<>(coursePages.size(),page,0,0,coursePages);
        return ResponseDto.ok(pageDto);
    }

    /**
     * Delete метод, удаляющий курс по его id
     * @param courseId
     * @return
     */

    @DeleteMapping("/{courseId}")
    public ResponseDto<?> deleteCourse(@PathVariable long courseId) {
        PageDto<CourseDto> page = new PageDto<>(0, 0
                , 0, 0, Collections.emptyList());
        return courseService.delete(courseId) ? ResponseDto.ok(page) : ResponseDto.error().build();
    }

    /**
     * Post метод, который создает копию курса по его id
     * @param courseId
     * @return
     */

    @PostMapping("/{courseId}/copy")
    public ResponseDto<?> copyCourse(@PathVariable long courseId) {
        PageDto<CoursePostDto> page = new PageDto<>(0, 0
                , 0, 0, Collections.emptyList());
        return courseService.copy(courseId) ? ResponseDto.ok(page) : ResponseDto.error().build();
    }

    /**
     * Put метод, обновляющий курс по CoursePostDto
     * @param courseId
     * @param course
     * @return
     */

    @PutMapping("/{courseId}")
    public ResponseDto<?> updateCourse(@PathVariable long courseId, @RequestBody CoursePutDto course) {
        PageDto<CoursePutDto> page = new PageDto<>(0, 0
                , 0, 0, Collections.emptyList());
        return courseService.save(course) ? ResponseDto.ok(page) : ResponseDto.error().build();
    }

    /**
     * Post метод, который создает новый курс из CoursePostDto
     * @param courseId
     * @param course
     * @return
     */

    @PostMapping("/{courseId}")
    public ResponseDto<?> createCourse(@PathVariable long courseId, @RequestBody CoursePostDto course) {
        PageDto<CoursePostDto> page = new PageDto<>(0, 0
                , 0, 0, Collections.emptyList());
        return courseService.save(course) ? ResponseDto.ok(page) : ResponseDto.error().build();
    }

    /**
     * Get метод, возвращающий лист модулей, в которых участвует курс по его id
     * @param courseId
     * @return
     */

    @GetMapping("/{courseId}/module")
    public ResponseDto<?> getModuleOfCourse(@PathVariable long courseId){
        List<ModuleDto> modules = moduleService.getModuleByCourse_Id(courseId);
        PageDto<ModuleDto> pageDto = new PageDto<>(modules.size(),0,0,0,modules);
        return ResponseDto.ok(pageDto);
    }

    /**
     * Post метод, который добавляет курс в новый модуль
     * @param courseId
     * @param module
     * @return
     */

    @PostMapping("/{courseId}/module")
    public ResponseDto<?> saveCourseOfModule(@PathVariable long courseId, @RequestBody ModulePostDto module) {
        PageDto<ModulePostDto> page = new PageDto<>(0, 0
                , 0, 0, Collections.emptyList());
        return moduleService.save(module) ? ResponseDto.ok(page) : ResponseDto.error().build();
    }

    /**
     * Get метод, который возращает лист кураторов определённого направления, если оно указано, иначе всех кураторов
     * @param directionId
     * @return
     */

    @GetMapping("/curator")
    public ResponseDto<?> getCuratorsByDirection_Id(@RequestParam(required = false) Long directionId){
        List<CuratorForCourseDto> curatorForCourseDtos = courseService.getCuratorsByDirection_Id(directionId);
        PageDto<CuratorForCourseDto> page = new PageDto<>(curatorForCourseDtos.size(),0,0,0,curatorForCourseDtos);
        return ResponseDto.ok(page);
    }
}
