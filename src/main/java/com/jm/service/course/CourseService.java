package com.jm.service.course;

import com.jm.dto.*;

import java.util.List;

public interface CourseService {

    /**
     * Возвращает лист курсов
     * @param search
     * @return
     */

   List<CourseDto> getCourses(String search);

    /**
     * Возвращает курс по id
     * @param id
     * @return
     */

   CourseDto getCourseById(long id);
    boolean delete (long id);

    /**
     * Копирует курс по id
     * @param id
     * @return
     */

    boolean copy (long id);

    /**
     * Проверяет наличие курса в базе по Id
     * @param id
     * @return
     */

    boolean isCourseExist(long id);

    /**
     * Следующие 2 метода сохраняют курс по POST или PUT запросу
     * @param course
     * @return
     */

    boolean save(CoursePutDto course);
    boolean save(CoursePostDto course);

    /**
     * Возвращает лист кураторов по направлениям, если направление не указано, то всех кураторов
     * @param directionId
     * @return
     */

    List<CuratorForCourseDto> getCuratorsByDirection_Id(Long directionId);

    /**
     * Возвращает лист CoursePage
     * @return
     */

    List<CoursePageDto> getCoursePageDto(String search);
}
