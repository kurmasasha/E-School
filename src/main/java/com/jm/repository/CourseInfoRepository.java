package com.jm.repository;

import com.jm.dto.CourseDto;
import com.jm.dto.CuratorForCourseDto;
import com.jm.model.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseInfoRepository extends JpaRepository<CourseInfo, Long> {

    /**
     * Запрос возвращает CourseDto по Course_Id
     *
     * @param id
     * @return
     */

    @Query(value = "select new com.jm.dto.CourseDto(c.course.id,c.course.name" +
            ",c.course.direction.id,c.curator.id" +
            ",c.course.isAvailable,c.course.htmlBody" +
            ",c.about,c.course.aboutTeacherInfo)" +
            " from CourseInfo c where c.course.id = ?1")
    CourseDto getCourseInfoByCourse_Id(long id);

    /**
     * Возвращает все курсы в виде List<CourseDto>
     *
     * @return
     */

    @Query(value = "select new com.jm.dto.CourseDto(c.course.id,c.course.name" +
            ",c.course.direction.id,c.curator.id" +
            ",c.course.isAvailable,c.course.htmlBody" +
            ",c.about,c.course.aboutTeacherInfo)" +
            " from CourseInfo c")
    List<CourseDto> getAllCourseInfo();

    /**
     * Возвращает все курсы подходящие под поисковую строку в виде List<CourseDto>
     *
     * @param search
     * @return
     */

    @Query(value = "select new com.jm.dto.CourseDto(c.course.id,c.course.name" +
            ",c.course.direction.id,c.curator.id" +
            ",c.course.isAvailable,c.course.htmlBody" +
            ",c.about,c.course.aboutTeacherInfo)" +
            " from CourseInfo c where c.course.name like ?1")
    List<CourseDto> findAllCourseInfoByCourse_NameLike(String search);

    /**
     * Возвращает всех кураторов работающих по одному направлению в виде List<CuratorForCourseDto>
     * @param id
     * @return
     */

    @Query(value = "select new com.jm.dto.CuratorForCourseDto(c.curator.id, c.curator.email" +
                                                            ", c.curator.firstName, c.curator.lastName) " +
                    "from CourseInfo c where c.course.direction.id = ?1")
    List<CuratorForCourseDto> findAllCuratorByDirection_id(long id);

    /**
     * Возращает лист кураторов в виде List<CuratorForCourseDto>
     * @return
     */

    @Query(value = "select new com.jm.dto.CuratorForCourseDto(c.curator.id, c.curator.email, c.curator.firstName, c.curator.lastName) from CourseInfo c where c.curator is not null")
    List<CuratorForCourseDto> findAllCurators();
}
