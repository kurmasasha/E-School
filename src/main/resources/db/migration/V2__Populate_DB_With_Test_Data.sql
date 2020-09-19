--- DIRECTION TABLE TEST DATA ---

insert into direction (name) values ('DirectionName1');
insert into direction (name) values ('DirectionName2');

--- COURSE TABLE TEST DATA ---

insert into course (about_teacher_info, creating_time, html_body, is_available, name, direction_id)
values ('TeacherInfo1', '2019-06-22 19:10:25-07', 'HtmlBody1', true, 'CourseName1', 1);

insert into course (about_teacher_info, creating_time, html_body, is_available, name, direction_id)
values ('TeacherInfo1', '2019-07-12 12:11:17-09', 'HtmlBody2', false, 'CourseName2', 2);

--- MODULE TABLE TEST DATA ---

insert into module (description, is_open, name, open_date, position, course_id)
values ('ModuleDescription1', true, 'ModuleName1', '2020-08-10', 1, 1);

insert into module (description, is_open, name, open_date, position, course_id)
values ('ModuleDescription2', true, 'ModuleName2', '2020-08-11', 2, 2);

--- TASK TABLE TEST DATA ---

insert into task (dtype, description, is_available, points, title, type, answer)
VALUES ('WordAnswerTask', 'DescriptionTask1', true, 10, 'Task1', 'TaskType1', 'TaskAnswer1');

insert into task (dtype, description, is_available, points, title, type, answer)
VALUES ('WordAnswerTask', 'DescriptionTask2', false, 20, 'Task2', 'TaskType2', 'TaskAnswer2');

insert into task (dtype, description, is_available, points, title, type, answer)
VALUES ('LectureTask', 'DescriptionTask3', true, 30, 'Task3', 'TaskType3', 'TaskAnswer3');

insert into task (dtype, description, is_available, points, title, type, answer)
VALUES ('LectureTask', 'DescriptionTask4', false, 40, 'Task4', 'TaskType4', 'TaskAnswer4');

insert into task (dtype, description, is_available, points, title, type, answer)
VALUES ('OrderingTask', 'DescriptionTask5', true, 50, 'Task5', 'TaskType5', 'TaskAnswer5');

insert into task (dtype, description, is_available, points, title, type, answer)
VALUES ('OrderingTask', 'DescriptionTask5', false, 60, 'Task6', 'TaskType6', 'TaskAnswer6');

insert into task (dtype, description, is_available, points, title, type, answer)
VALUES ('TheoryTask', 'DescriptionTask7', true, 70, 'Task7', 'TaskType7', 'TaskAnswer7');

insert into task (dtype, description, is_available, points, title, type, answer)
VALUES ('TheoryTask', 'DescriptionTask8', false, 80, 'Task8', 'TaskType8', 'TaskAnswer8');

insert into task (dtype, description, is_available, points, title, type, answer)
VALUES ('Task', 'DescriptionTask9', true, 90, 'Task9', 'TaskType9', 'TaskAnswer9');

insert into task (dtype, description, is_available, points, title, type, answer)
VALUES ('Task', 'DescriptionTask10', false, 100, 'Task10', 'TaskType10', 'TaskAnswer10');

--- USERS TABLE TEST DATA ---

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date, role)
VALUES ('Teacher', 'teacher1@mail.com', true, 'TeacherName1', 'TeacherLastName1', '123456', '2019-05-20', '\x01');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date, role)
VALUES ('Teacher', 'teacher2@mail.com', true, 'TeacherName2', 'TeacherLastName2', '7777777', '2019-07-11', '\x02');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date, role)
VALUES ('User', 'user1@mail.com', true, 'UserName1', 'UserLastName1', '555555', '2019-02-05', '\x01');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date, role)
VALUES ('User', 'user2@mail.com', true, 'UserName2', 'UserLastName2', '11111111', '2019-03-17', '\x02');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date, role)
VALUES ('Admin', 'admin1@mail.com', true, 'AdminName1', 'AdminLastName1', '6666666', '2019-05-20', '\x01');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date, role)
VALUES ('Admin', 'admin2@mail.com', true, 'AdminName2', 'AdminLastName2', '1212121212', '2019-03-02', '\x02');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date, role)
VALUES ('Student', 'student1@mail.com', true, 'StudentName1', 'StudentLastName1', '999999', '2019-08-14', '\x01');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date, role)
VALUES ('Student', 'student2@mail.com', true, 'StudentName2', 'StudentLastName2', '8888888', '2019-12-06', '\x02');

--- CHAPTER TABLE TEST DATA ---

insert into chapter (name, position, module_id)
values ('Chapter1', 1, 1);

insert into chapter (name, position, module_id)
values ('Chapter2', 2, 2);

--- COURSE INFO TABLE TEST DATA ---

insert into course_info (about, description, course_id, teacher_id)
values ('About1', 'Description1', 1, 1);

insert into course_info (about, description, course_id, teacher_id)
values ('About2', 'Description2', 2, 2);

--- COURSE TASK TABLE TEST DATA ---

insert into course_task (position, chapter_id, task_id)
values (1, 1, 1);
insert into course_task (position, chapter_id, task_id)
values (2, 2, 2);

--- CUSTOM ANSWER TABLE TEST DATA ---

insert into custom_answer (text) values ('CustomAnswer1');
insert into custom_answer (text) values ('CustomAnswer2');

--- PROBABLY ANSWER TABLE TEST DATA ---

insert into probably_answer (is_right, text, theory_task_id)
values (true, 'ProbablyAnswerText1', 1);
insert into probably_answer (is_right, text, theory_task_id)
values (false, 'ProbablyAnswerText2', 2);

--- ORDERING TASK ITEM TABLE TEST DATA ---

insert into ordering_task_item (item_text, position, ordering_task_id)
values ('OrderingTaskItem1', 1, 1);
insert into ordering_task_item (item_text, position, ordering_task_id)
values ('OrderingTaskItem2', 2, 2);


--- STUDENT COURSE INFO TABLE TEST DATA ---

insert into student_course_info (adding_date, is_completed, course_id, user_id)
values ('2020-01-03', true, 1, 1);
insert into student_course_info (adding_date, is_completed, course_id, user_id)
values ('2020-02-09', false, 2, 2);

--- STUDENT COURSE TASK TABLE TEST DATA ---

insert into student_course_task (is_reset, is_right, is_solved, is_wrong, course_task_id, student_course_info_id)
values (false, true, true, false, 1, 1);

insert into student_course_task (is_reset, is_right, is_solved, is_wrong, course_task_id, student_course_info_id)
values (true, false, true, true, 2, 2);

--- ORDERING TASK ANSWER ITEM TABLE TEST DATA ---

insert into ordering_task_answer_item (position, ordering_task_item_id, probably_answer_id)
values (1, 1, 1);
insert into ordering_task_answer_item (position, ordering_task_item_id, probably_answer_id)
values (2, 2, 2);

--- STUDENT COURSE TASK ANSWER TABLE TEST DATA ---

insert into student_course_task_answer (answer, date, is_right, custom_answer_id, ordering_task_answer_item_id, student_course_task_id)
values ('CourseTaskAnswer1', '2020-05-10', true, 1, 1, 1);

insert into student_course_task_answer (answer, date, is_right, custom_answer_id, ordering_task_answer_item_id, student_course_task_id)
values ('CourseTaskAnswer2', '2020-06-17', false, 2, 2, 2);

--- Setting student_course_task_answer_id in ordering_task_answer_item
update ordering_task_answer_item set student_course_task_answer_id = 1 where id = 1;
update ordering_task_answer_item set student_course_task_answer_id = 2 where id = 2;

--- STUDENT GROUP TABLE TEST DATA ---

insert into student_group (name, course_id, teacher_id)
values ('StudentGroupName1', 1, 1);
insert into student_group (name, course_id, teacher_id)
values ('StudentGroupName2', 2, 2);

--- Filling in link tables ---
insert into student_course_info_student_course_tasks (student_course_info_id, student_course_tasks_id)
VALUES (1, 1);

insert into student_course_info_student_course_tasks (student_course_info_id, student_course_tasks_id)
VALUES (2, 2);

insert into student_course_task_student_course_task_answers (student_course_task_id, student_course_task_answers_id)
VALUES (1, 1);

insert into student_course_task_student_course_task_answers (student_course_task_id, student_course_task_answers_id)
VALUES (2, 2);

insert into task_probably_answers (theory_task_id, probably_answers_id) VALUES (1, 1);
insert into task_probably_answers (theory_task_id, probably_answers_id) VALUES (2, 2);

insert into task_task_items (ordering_task_id, task_items_id) VALUES (1, 1);
insert into task_task_items (ordering_task_id, task_items_id) VALUES (2, 2);