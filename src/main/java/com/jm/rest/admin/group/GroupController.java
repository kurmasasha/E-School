package com.jm.rest.admin.group;

import com.jm.dto.*;
import com.jm.model.StudentGroup;
import com.jm.service.user.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public List<CourseInfoDto> getCoursesByDirectionId(@RequestParam(required = false) Optional<Long> directionId) {
        List<CourseInfoDto> courses;
        if (directionId.isPresent()) {
            courses = groupService.getCoursesByDirectionId(directionId.get());
        } else {
            courses = groupService.getAllCourses();
        }
        return courses;
    }


    // GET /api/admin/group?page=integer&search=string
    // в качеве ответа приходит ResponseDto<PageDto<GroupPageDto>>

//    @GetMapping
//    public ResponseDto<PageDto<GroupPageDto>> getGroupsBySearch(@RequestParam Integer page, @RequestParam String search) {
//
//        List<GroupPageDto> groups = groupService.getGroupsBySearch(search);
//        PageDto<GroupPageDto> pageDto = new PageDto<>(groups.size(), page, 0, 0, groups);
//        return ResponseDto.ok(pageDto);
//
//    }


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
    public PageDto<List<StudentUserDto>> getStudentsInGroup(@PathVariable Long groupId,
                                                            @RequestParam Integer page,
                                                            @RequestParam String search) {

        return groupService.getStudentsInGroup(groupId);

    }


    // PATCH /api/admin/group/{groupId}/student/remove
    // в качетсе тела передается список id студентов для удаления из группы
    // (физичесого удаления сявзи с группой из базы не происходит, менятся флаг removed = true в
    // сущности связи студента с группой, для сохранения статистики и истории)

    @PatchMapping("/{groupId}/student/remove")
    public ResponseDto<?> removeStudents(@PathVariable Long groupId, @RequestBody List<Long> removingStudents) {

        StudentGroup group = groupService.getGroupById(groupId);

//        group.
        return ResponseDto.ok().build();

    }


    // PUT /api/admin/group/{groupId}
    // в качетве тела передается GroupPostDto

    @PutMapping("/{groupId}")
    public ResponseDto<?> updateGroup(@PathVariable Long groupId, @RequestBody GroupPostDto groupPostDto) {

        groupService.updateGroupById(groupId, groupPostDto);
        return ResponseDto.ok().build();


    }


}
