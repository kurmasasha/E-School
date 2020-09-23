package com.jm.service.user;

import com.jm.dto.*;
import com.jm.model.*;
import com.jm.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Сервис для работы со студенческими группами
 *
 * @author Java Mentor
 *
 * @version 1.0
 */
@Service
public class GroupServiceImpl implements GroupService {

    private final StudentGroupRepository groupRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final List<GroupPageDto> groupPageDtoList = new ArrayList<>();
    private List<TeacherForGroupDto> teacherForGroupDtoList = new ArrayList<>();
    private List<CourseDto> courseDtoList = new ArrayList<>();

    @Autowired
    public GroupServiceImpl(StudentGroupRepository groupRepository, TeacherRepository teacherRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * метод получения списка курсов по направлению обучения
     *
     * @param directionId учетный номер направления обучения
     * @return List<CourseDto>, который содержит список выбранных курсов
     */
    @Override
    public List<CourseDto> getCoursesByDirectionId(Long directionId) {
        courseDtoList = courseRepository.findAllWithDirectionId(directionId);
        return courseDtoList;
    }


    /**
     * метод получения списка всех курсов из системы
     *
     * @return List<CourseDto>, который содержит список всех курсов
     */
    @Override
    public List<CourseDto> getAllCourses() {

        courseDtoList.clear();
        List<Course> courseList = courseRepository.findAll();
        for (Course i : courseList) {
            CourseDto currentDto = new CourseDto(i.getId(),
                                                 i.getName(),
                                                 i.getDescription(),
                                                 i.getHtmlBody(),
                                                 i.getAvailable(),
                                                 i.getCreatingTime(),
                                                 i.getCurator().getId(),
                                                 i.getDirection().getId());
            courseDtoList.add(currentDto);
        }
        return courseDtoList;
    }

    /**
     * метод получения групп по поисковому запросу (поиск по имени группы)
     *
     * @param search поисковый запрос по имени группы
     * @return List<GroupPageDto>, который содержит список выбранных групп
     */
    @Override
    public List<GroupPageDto> getGroupsDtoWithSearch(String search) {

        groupPageDtoList.clear();
        List<StudentGroup> groups = groupRepository.getGroupsWithSearch(search);
        for (StudentGroup i : groups){
            GroupPageDto pageDto = new GroupPageDto(i.getId(),
                                                    i.getName(),
                                                    i.getCourse().getName(),
                                                    i.getCourse().getDirection().getName(),
                                                    i.getCourse().getCurator().getFirstName() + i.getCourse().getCurator().getLastName(),
                                                    i.getTeacher().getFirstName() + i.getTeacher().getLastName(),
                                                    i.getStudentList().size());
            groupPageDtoList.add(pageDto);
        }
        return groupPageDtoList;
    }

    /**
     * метод получения всех учителей из системы
     *
     * @return List<TeacherForGroupDto>, который содержит список учителей
     */
    @Override
    public List<TeacherForGroupDto> getAllTeachersForGroup() {

        teacherForGroupDtoList = teacherRepository.getAllTeachersForGroupDto();

        return teacherForGroupDtoList;
    }

    /**
     * метод получения учителей по направлению обучения
     *
     * @param directionId учетный номер направления обучения
     * @return List<TeacherForGroupDto>, который содержит список выбранных учителей
     */
    @Override
    public List<TeacherForGroupDto> getTeachersByDirectionId(Long directionId) {

        Set<TeacherForGroupDto> teacherSet = new HashSet<>();
        List<StudentGroup> allGroups = groupRepository.findAll();

        for (StudentGroup i : allGroups) {
            if (i.getCourse().getDirection().getId().equals(directionId)) {
                teacherSet.add(new TeacherForGroupDto(i.getTeacher().getId(),
                                                      i.getTeacher().getEmail(),
                                                      i.getTeacher().getFirstName(),
                                                      i.getTeacher().getLastName()));
            }

        }
        teacherForGroupDtoList.clear();
        teacherForGroupDtoList.addAll(teacherSet);

        return teacherForGroupDtoList;
    }

    /**
     * метод получения списка студентов по номеру группы
     *
     * @param groupId учетный номер группы
     * @return List<StudentUserDto>, который содержит список студентов в группе, у которых isEnabled = true
     */
    @Override
    public List<StudentUserDto> getStudentsInGroup(Long groupId) {

        List<StudentUserDto> studentsDto = new ArrayList<>();
        StudentGroup group = groupRepository.findById(groupId).get();
        Set<Student> students = group.getStudentList();

        for (Student i : students) {
            if (i.getEnabled()) {
                studentsDto.add(new StudentUserDto(i.getId(),
                                                   i.getEmail(),
                                                   i.getFirstName(),
                                                   i.getLastName(),
                                                   group.getCourse().getDirection().getName(),
                                                   group.getId(),
                                                   i.getEnabled()));
            }
        }
        return studentsDto;
    }

    /**
     * метод получения группы по учетному номеру (Id)
     *
     * @param groupId учетный номер группы
     * @return объект StudentGroup, соответствующий учетному номеру
     */
    @Override
    public StudentGroup getGroupById(Long groupId){
        return groupRepository.findById(groupId).get();
    }

    /**
     * метод удаления студента из группы по учетному номеру студента (Id) путем утановления полю student.enabled значения false
     *
     * @param id учетный номер студента для удаления
     * @return удаленного студента класса User
     */
    @Override
    public Student removeStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        student.setEnabled(false);
        return student;
    }

    /**
     * метод обновления учетных данных группы по ее учетному номеру (Id)
     *
     * @param groupId учетный номер группы
     * @param groupPostDto объект, содержащий новые учетные данные
     * @return объект класса StudentGroup, содержащий новое состояние измененной группы
     */
    @Override
    @Transactional
    public StudentGroup updateGroupById(Long groupId, GroupPostDto groupPostDto) {
        StudentGroup group = groupRepository.findById(groupId).get();
        group.setName(groupPostDto.getName());
        group.setCourse(courseRepository.getOne(groupPostDto.getCourseId()));
        group.setTeacher(teacherRepository.getOne(groupPostDto.getTeacherId()));
        return group;
    }
}
