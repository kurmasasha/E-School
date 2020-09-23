package com.jm.rest.admin.group;

import com.jm.dto.*;
import com.jm.model.User;
import com.jm.service.user.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Rest контроллер студенческих групп
 *
 * @author Java Mentor
 * @version 1.0
 */
@RestController
@RequestMapping("/api/admin/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    /**
     * GET метод получения курсов по направлению обучения. Если параметр не задан, то возвращаются все курсы из системы.
     *
     * @param directionId идентификационный номер направления обучения
     *
     * @return List<CourseDto> - список курсов, связанных с заданным направлением,
     * у которых isAvailable = true.
     */
    @GetMapping("/course")
    public List<CourseDto> getCoursesByDirectionId(@RequestParam(required = false) Optional<Long> directionId) {
        List<CourseDto> courses;
        if (directionId.isPresent()) {
            courses = groupService.getCoursesByDirectionId(directionId.get());
        } else {
            courses = groupService.getAllCourses();
        }
        return courses;
    }

    /**
     * GET метод, возвращающий список групп по ключу поиска.
     *
     * @param page номер страницы поисковой выдачи
     *
     * @param search ключ поискового запроса
     *
     * @return ResponseDto, содержащий страницу со списком групп.
     */
    @GetMapping
    public ResponseDto<PageDto<GroupPageDto>> getGroupsBySearch(@RequestParam Integer page, @RequestParam String search) {

        List<GroupPageDto> groups = groupService.getGroupsDtoWithSearch(search);
        PageDto<GroupPageDto> pageDto = new PageDto<>(groups.size(), page, 0, 0, groups);
        return ResponseDto.ok(pageDto);

    }

    /**
     * GET метод, возвращающий список учителей по направлению обучения. Если запрос пустой, то возвращаются все учителя из системы.
     *
     * @param directionId номер страницы поисковой выдачи
     *
     * @return List<TeacherForGroupDto>.
     */
    @GetMapping("/teacher")
    public List<TeacherForGroupDto> getTeachersByDirectionId(@RequestParam(required = false) Optional<Long> directionId) {
        List<TeacherForGroupDto> teachers;
        if (directionId.isPresent()) {
            teachers = groupService.getTeachersByDirectionId(directionId.get());
        } else {
            teachers = groupService.getAllTeachersForGroup();
        }
        return teachers;
    }

    /**
     * GET метод получения списка юзеров по учетному номеру группы с возможностью поисковой фильтрации
     *
     * @param groupId учетный номер группы
     * @param page номер страницы
     * @param search возможный поисковой запрос
     * @return PageDto<StudentUserDto>, который содержит результат
     */
    @GetMapping("/{groupId}/student")
    public PageDto<StudentUserDto> getStudentsInGroup(@PathVariable Long groupId,
                                                            @RequestParam Integer page,
                                                            @RequestParam String search) {

        List<StudentUserDto> students = groupService.getStudentsInGroup(groupId);
        if (!search.isEmpty()) {
            List<StudentUserDto> studentsBySearch = new ArrayList<>();
            for (StudentUserDto i : students) {
                if (i.getFirstName().contains(search) || i.getLastName().contains(search)) {
                    studentsBySearch.add(i);
                }
            }
            return new PageDto<>(studentsBySearch.size(), page, 0, 0, studentsBySearch);
        }
        return new PageDto<>(students.size(), page, 0, 0, students);
    }

    /**
     * PATCH метод удаления студентов из группы. Удаление происходит путем присвоения false полю student.enabled
     *
     * @param groupId учетный номер группы
     * @param removingStudents список ID студентов для удаления
     * @return ResponseDto, который содержит список удаленных студентов.
     */
    @PatchMapping("/{groupId}/student/remove")
    @Transactional
    public ResponseDto<?> removeStudents(@PathVariable Long groupId, @RequestBody List<Long> removingStudents) {

        List<User> deleted = new ArrayList<>();

        for (Long i : removingStudents) {
            deleted.add(groupService.removeStudentById(i));
        }
        return ResponseDto.ok(deleted);

    }


    /**
     * PUT метод обновления учетных данных группы.
     *
     * @param groupId учетный номер группы
     * @param groupPostDto объект с новыми учетными данными
     * @return ResponseDto, который содержит измененное состояние группы.
     */
    @PutMapping("/{groupId}")
    public ResponseDto<?> updateGroup(@PathVariable Long groupId, @RequestBody GroupPostDto groupPostDto) {

        return ResponseDto.ok(groupService.updateGroupById(groupId, groupPostDto));

    }


}
