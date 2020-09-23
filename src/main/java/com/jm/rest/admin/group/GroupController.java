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

@RestController
@RequestMapping("/api/admin/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    // GET /api/admin/group/course?directionId=long
    // (directionId не required параметр) в качтесве ответа приходит List<CourseInfoDto>
    // (если directionId пустой то все курсы из системы иначе только связаные с
    // переданным направлением, у которых isAvailable true )

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


    // GET /api/admin/group?page=integer&search=string
    // в качеве ответа приходит ResponseDto<PageDto<GroupPageDto>>

    @GetMapping
    public ResponseDto<PageDto<GroupPageDto>> getGroupsBySearch(@RequestParam Integer page, @RequestParam String search) {

        List<GroupPageDto> groups = groupService.getGroupsDtoWithSearch(search);
        PageDto<GroupPageDto> pageDto = new PageDto<>(groups.size(), page, 0, 0, groups);
        return ResponseDto.ok(pageDto);

    }


    // GET /api/admin/group/teacher?directionId
    // (directionId не required параметр) в качестве ответа приходит List<TeacherForGroupDto>
    // (если directionId пустой то все преподаватели из системы иначе только связаные с переданным направлением )

    @GetMapping("/teacher")
    public List<TeacherForGroupDto> getTeachersByDirectionId(@RequestParam(required = false) Optional<Long> directionId) {
        List<TeacherForGroupDto> teachers;
        if (directionId.isPresent()) {
            teachers = groupService.getTeachersByDirectionId(directionId.get());
        } else {
            teachers = groupService.getAllTeachers();
        }
        return teachers;
    }


    // GET /api/admin/group/{groupId}/student?page=integer&search=string
    // В качестве ответа приходит PageDto<List<StudentUserDto>>
    // (все которые находятся в группе с флагом removed = false)

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


    // PATCH /api/admin/group/{groupId}/student/remove
    // в качетсе тела передается список id студентов для удаления из группы
    // (физичесого удаления сявзи с группой из базы не происходит, менятся флаг removed = true в
    // сущности связи студента с группой, для сохранения статистики и истории)

    @PatchMapping("/{groupId}/student/remove")
    @Transactional
    public ResponseDto<?> removeStudents(@PathVariable Long groupId, @RequestBody List<Long> removingStudents) {

        List<User> deleted = new ArrayList<>();

        for (Long i : removingStudents) {
            deleted.add(groupService.removeStudentById(i));
        }
        return ResponseDto.ok(deleted);

    }


    // PUT /api/admin/group/{groupId}
    // в качетве тела передается GroupPostDto

    @PutMapping("/{groupId}")
    public ResponseDto<?> updateGroup(@PathVariable Long groupId, @RequestBody GroupPostDto groupPostDto) {

        return ResponseDto.ok(groupService.updateGroupById(groupId, groupPostDto));

    }


}
