--- USERS TABLE TEST DATA ---

insert into users (dtype, email, enabled, first_name, last_name, password)
VALUES ('Teacher', 'teacher1@mail.com', true, 'TeacherName1', 'TeacherLastName1', '123456');

insert into users (dtype, email, enabled, first_name, last_name, password)
VALUES ('Teacher', 'teacher2@mail.com', true, 'TeacherName2', 'TeacherLastName2', '7777777');

insert into users (dtype, email, enabled, first_name, last_name, password)
VALUES ('User', 'user1@mail.com', true, 'UserName1', 'UserLastName1', '555555');

insert into users (dtype, email, enabled, first_name, last_name, password)
VALUES ('User', 'user2@mail.com', true, 'UserName2', 'UserLastName2', '11111111');

insert into users (dtype, email, enabled, first_name, last_name, password)
VALUES ('Admin', 'admin1@mail.com', true, 'AdminName1', 'AdminLastName1', '6666666');

insert into users (dtype, email, enabled, first_name, last_name, password)
VALUES ('Admin', 'admin2@mail.com', true, 'AdminName2', 'AdminLastName2', '1212121212');

insert into users (dtype, email, enabled, first_name, last_name, password)
VALUES ('Student', 'student1@mail.com', true, 'StudentName1', 'StudentLastName1', '999999');

insert into users (dtype, email, enabled, first_name, last_name, password)
VALUES ('Student', 'student2@mail.com', true, 'StudentName2', 'StudentLastName2', '8888888');

--- CHAPTER TABLE TEST DATA ---

insert into chapter (name, position)
values ('Chapter1', 1);

insert into chapter (name, position)
values ('Chapter2', 2);

--- COURSE TABLE TEST DATA ---

insert into course (name, html_body, about_teacher_info, is_available)
values ('Course1', 'HtmlBody1', 'TeacherInfo1', true);

insert into course (name, html_body, about_teacher_info, is_available)
values ('Course2', 'HtmlBody2', 'TeacherInfo2', true);

--- COURSE INFO TABLE TEST DATA ---

insert into course_info (about, description)
values ('About1', 'Description1');

insert into course_info (about, description)
values ('About2', 'Description2');

--- COURSE TASK TABLE TEST DATA ---

insert into course_task (position) values (1);
insert into course_task (position) values (2);

--- CUSTOM ANSWER TABLE TEST DATA ---

insert into custom_answer (text) values ('CustomAnswer1');
insert into custom_answer (text) values ('CustomAnswer2');

--- DIRECTION TABLE TEST DATA ---

insert into direction (name) values ('DirectionName1');
insert into direction (name) values ('DirectionName2');

--- MODULE TABLE TEST DATA ---

insert into module (description, is_open, name, open_date, position)
values ('ModuleDescription1', true, 'ModuleName1', '2020-08-10', 1);

insert into module (description, is_open, name, open_date, position)
values ('ModuleDescription2', true, 'ModuleName2', '2020-08-11', 2);

--- ORDERING TASK ANSWER ITEM TABLE TEST DATA ---

insert into ordering_task_answer_item (position) values (1);
insert into ordering_task_answer_item (position) values (2);

--- ORDERING TASK ITEM TABLE TEST DATA ---

insert into ordering_task_item (item_text, position) values ('OrderingTaskItem1', 1);
insert into ordering_task_item (item_text, position) values ('OrderingTaskItem2', 2);

--- PROBABLY ANSWER TAB:E TEST DATA ---

insert into probably_answer (is_right, text) values (true, 'ProbablyAnswerText1');
insert into probably_answer (is_right, text) values (false, 'ProbablyAnswerText2');

--- STUDENT COURSE INFO TABLE TEST DATA ---

insert into student_course_info (adding_date, is_completed) values ('2020-01-03', true);
insert into student_course_info (adding_date, is_completed) values ('2020-02-09', false);

--- STUDENT COURSE TASK TABLE TEST DATA ---

insert into student_course_task (is_reset, is_right, is_solved, is_wrong)
values (false, true, true, false);

insert into student_course_task (is_reset, is_right, is_solved, is_wrong)
values (true, false, true, true);

--- STUDENT COURSE TASK ANSWER TABLE TEST DATA ---

insert into student_course_task_answer (answer, date, is_right)
values ('CourseTaskAnswer1', '2020-05-10', true);

insert into student_course_task_answer (answer, date, is_right)
values ('CourseTaskAnswer2', '2020-06-17', false);

--- STUDENT GROUP TABLE TEST DATA ---

insert into student_group (name) values ('StudentGroupName1');
insert into student_group (name) values ('StudentGroupName2');

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