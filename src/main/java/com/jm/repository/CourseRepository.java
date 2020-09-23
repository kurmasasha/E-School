package com.jm.repository;

import com.jm.dto.CourseDto;
import com.jm.dto.CoursePageDto;
import com.jm.dto.CuratorForCourseDto;
import com.jm.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     * Возвращает количество найденых курсов по его id
     * @param id
     * @return
     */

    @Query(value = "select count(c) from Course c where c.id = ?1")
    Long isCourseExist(long id);

    /**
     * Запрос возвращает CourseDto по Course_Id
     *
     * @param id
     * @return
     */

    @Query(value = "select new com.jm.dto.CourseDto(c)" +
            " from Course c where c.id = ?1")
    CourseDto getCourseById(long id);
//
    /**
     * Возвращает все курсы в виде List<CourseDto>
     *
     * @return
     */

    @Query(value = "select new com.jm.dto.CourseDto(c)" +
            " from Course c")
    List<CourseDto> getAllCourse();

    /**
     * Возвращает все курсы подходящие под поисковую строку в виде List<CourseDto>
     *
     * @param search
     * @return
     */

    @Query(value = "select new com.jm.dto.CourseDto(c)" +
            " from Course c where c.name like ?1")
    List<CourseDto> findAllCourseByNameLike(String search);

    /**
     * Возвращает всех кураторов работающих по одному направлению в виде List<CuratorForCourseDto>
     * @param id
     * @return
     */

    @Query(value = "select new com.jm.dto.CuratorForCourseDto(" +
            "c.curator.id" +
            ", c.curator.email" +
            ", c.curator.firstName, c.curator.lastName) " +
            "from Course c where c.direction.id = ?1")
    List<CuratorForCourseDto> findAllCuratorByDirection_id(long id);
//
    /**
     * Возращает лист кураторов в виде List<CuratorForCourseDto>
     * @return
     */

    @Query(value = "select new com.jm.dto.CuratorForCourseDto(" +
            "c.curator.id," +
            " c.curator.email," +
            " c.curator.firstName," +
            " c.curator.lastName) from Course c where c.curator is not null")
    List<CuratorForCourseDto> findAllCurators();

    /**
     * Возвращает лист CoursePage у которых в имени содержится строка search
     * @param search
     * @return
     */

    @Query(value = "select new com.jm.dto.CoursePageDto(c) from Course c where c.name like ?1")
    List<CoursePageDto> getCoursePageDtoLike(String search);

    /**
     * Возвращает лист всех курсов в виде CoursePage
     * @return
     */

    @Query(value = "select new com.jm.dto.CoursePageDto(c) from Course c")
    List<CoursePageDto> getAllCoursePageDto();

}
