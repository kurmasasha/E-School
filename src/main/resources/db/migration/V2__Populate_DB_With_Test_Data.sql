--- USERS TEST DATA ---
insert into users (dtype, email, enabled, first_name, last_name, password, registration_date)
VALUES ('Teacher', 'teacher1@mail.com', true, 'Steven', 'Hawking', '123456', '2019-05-20');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date)
VALUES ('Teacher', 'teacher2@mail.com', true, 'Gordon', 'Freeman', '7777777', '2019-07-11');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date)
VALUES ('User', 'user1@mail.com', true, 'UserName1', 'UserLastName1', '555555', '2019-02-05');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date)
VALUES ('User', 'user2@mail.com', true, 'UserName2', 'UserLastName2', '11111111', '2019-03-17');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date)
VALUES ('Admin', 'admin1@mail.com', true, 'Mark', 'Spencer', '6666666', '2019-05-20');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date)
VALUES ('Admin', 'admin2@mail.com', true, 'Helen', 'Vancouver', '1212121212', '2019-03-02');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date)
VALUES ('Student', 'student1@mail.com', true, 'Ian', 'Johnson', '999999', '2019-08-14');

insert into users (dtype, email, enabled, first_name, last_name, password, registration_date)
VALUES ('Student', 'student2@mail.com', true, 'Kevin', 'MacCullister', '8888888', '2019-12-06');

--- DIRECTIONS TEST DATA ---
insert into directions (name)
values ('DirectionName1');
insert into directions (name)
values ('DirectionName2');

--- COURSES TEST DATA ---
insert into courses (creating_time, description, html_body, is_available, name, teacher_id, direction_id)
values ('2019-06-22 19:10:25-07', 'Description1', 'HtmlBody1', true, 'CourseName1', 1, 1);

insert into courses (creating_time, description, html_body, is_available, name, teacher_id, direction_id)
values ('2019-07-12 12:11:17-09', 'Description2', 'HtmlBody2', false, 'CourseName2', 2, 2);

--- MODULES TEST DATA ---
insert into modules (description, is_open, name, open_date, position, course_id)
values ('ModuleDescription1', true, 'ModuleName1', '2020-08-10', 1, 1);

insert into modules (description, is_open, name, open_date, position, course_id)
values ('ModuleDescription2', true, 'ModuleName2', '2020-08-11', 2, 2);

--- CHAPTERS TEST DATA ---
insert into chapters (name, position, module_id)
values ('Chapter1', 1, 1);
insert into chapters (name, position, module_id)
values ('Chapter2', 2, 2);

--- TASKS TEST DATA ---
insert into tasks (dtype, description, is_available, name, points, position, type, answer)
VALUES ('WordAnswerTask', 'DescriptionTask1', true, 'Task1', 10, 1, 'TaskType1', 'TaskAnswer1');

insert into tasks (dtype, description, is_available, name, points, position, type, answer)
VALUES ('WordAnswerTask', 'DescriptionTask2', false, 'Task2', 20, 2, 'TaskType2', 'TaskAnswer2');

insert into tasks (dtype, description, is_available, name, points, position, type, answer)
VALUES ('LectureTask', 'DescriptionTask3', true, 'Task3', 30, 3, 'TaskType3', 'TaskAnswer3');

insert into tasks (dtype, description, is_available, name, points, position, type, answer)
VALUES ('LectureTask', 'DescriptionTask4', false, 'Task4', 40, 4, 'TaskType4', 'TaskAnswer4');

insert into tasks (dtype, description, is_available, name, points, position, type, answer)
VALUES ('OptionTask', 'DescriptionTask5', true, 'Task5', 50, 5, 'TaskType5', 'TaskAnswer5');

insert into tasks (dtype, description, is_available, name, points, position, type, answer)
VALUES ('OptionTask', 'DescriptionTask5', false, 'Task6', 60, 6, 'TaskType6', 'TaskAnswer6');

insert into tasks (dtype, description, is_available, name, points, position, type, answer)
VALUES ('TheoryTask', 'DescriptionTask7', true, 'Task7', 70, 7, 'TaskType7', 'TaskAnswer7');

insert into tasks (dtype, description, is_available, name, points, position, type, answer)
VALUES ('TheoryTask', 'DescriptionTask8', false, 'Task8', 80, 8, 'TaskType8', 'TaskAnswer8');

insert into tasks (dtype, description, is_available, name, points, position, type, answer)
VALUES ('Task', 'DescriptionTask9', true, 'Task9', 90, 9, 'TaskType9', 'TaskAnswer9');

insert into tasks (dtype, description, is_available, name, points, position, type, answer)
VALUES ('Task', 'DescriptionTask10', false, 'Task10', 100, 10, 'TaskType10', 'TaskAnswer10');

--- PERSONAL STUDENT COURSES TEST DATA ---
insert into personal_student_courses (adding_date, is_completed, course_id, user_id)
values ('2020-01-03', true, 1, 1);
insert into personal_student_courses (adding_date, is_completed, course_id, user_id)
values ('2020-02-09', false, 2, 2);

--- PERSONAL STUDENTS COURSE TASKS TEST DATA ---
insert into personal_students_course_tasks (is_completed, is_solved, personal_student_course_id, task_id)
values (true, true, 1, 1);

insert into personal_students_course_tasks (is_completed, is_solved, personal_student_course_id, task_id)
values (false, false, 2, 2);

--- POSSIBLE ANSWERS ---
insert into possible_answers (is_right, text, theory_task_id)
values (true, 'ProbablyAnswerText1', 1);
insert into possible_answers (is_right, text, theory_task_id)
values (false, 'ProbablyAnswerText2', 2);

--- OPTION TASK ITEMS TEST DATA ---
insert into option_task_items (item_text, position, option_task_id)
values ('ItemText1', 1, 1);
insert into option_task_items (item_text, position, option_task_id)
values ('ItemText2', 2, 2);

--- POSSIBLE STUDENT TASK ANSWERS ---
insert into possible_student_task_answers (text, possible_answer_id)
values ('AnswerText1', 1);
insert into possible_student_task_answers (text, possible_answer_id)
values ('AnswerText2', 2);

--- STUDENT TASK ANSWERS ---
insert into student_task_answers (dtype, date, is_right, answer, personal_student_course_task_id,
                                  possible_student_task_answer_id)
values ('OptionTaskStudentAnswer', '2020-05-10', true, 'TaskAnswer1', 1, 1);

insert into student_task_answers (dtype, date, is_right, answer, personal_student_course_task_id,
                                  possible_student_task_answer_id)
values ('OptionTaskStudentAnswer', '2020-06-17', false, 'TaskAnswer2', 2, 2);

insert into student_task_answers (dtype, date, is_right, answer, personal_student_course_task_id,
                                  possible_student_task_answer_id)
values ('TheoryStudentTaskAnswer', '2020-04-05', true, 'TaskAnswer3', 1, 1);

insert into student_task_answers (dtype, date, is_right, answer, personal_student_course_task_id,
                                  possible_student_task_answer_id)
values ('TheoryStudentTaskAnswer', '2020-03-09', false, 'TaskAnswer4', 2, 2);

insert into student_task_answers (dtype, date, is_right, answer, personal_student_course_task_id,
                                  possible_student_task_answer_id)
values ('WordStudentTaskAnswer', '2020-08-18', true, 'TaskAnswer5', 1, 1);

insert into student_task_answers (dtype, date, is_right, answer, personal_student_course_task_id,
                                  possible_student_task_answer_id)
values ('WordStudentTaskAnswer', '2020-11-11', false, 'TaskAnswer6', 2, 2);

--- UPDATE POSSIBLE STUDENT TASK ANSWERS TABLE ---
update possible_student_task_answers
set theory_student_task_answer_id=3
where id = 1;
update possible_student_task_answers
set theory_student_task_answer_id=4
where id = 2;

--- OPTION STUDENT TASK ITEMS TEST DATA ---
insert into option_student_task_items (position, option_task_student_answer_id, option_task_item_id)
values (1, 1, 1);

insert into option_student_task_items (position, option_task_student_answer_id, option_task_item_id)
values (2, 2, 2);

--- STUDENT GROUPS TEST DATA ---
insert into student_groups (name, course_id, teacher_id)
values ('Group1', 1, 1);
insert into student_groups (name, course_id, teacher_id)
values ('Group2', 2, 2);

-- SETTING IDS INTO LINK TABLES ---
insert into student_group_student (student_group_id, student_id)
values (1, 7);
insert into student_group_student (student_group_id, student_id)
values (2, 8);
insert into student_task_answers_option_student_task_answer_item (option_task_student_answer_id, option_student_task_answer_item_id)
values (1, 1);
insert into student_task_answers_option_student_task_answer_item (option_task_student_answer_id, option_student_task_answer_item_id)
values (2, 2);
insert into task_chapter (task_id, chapter_id)
values (1, 1);
insert into task_chapter (task_id, chapter_id)
values (2, 2);
insert into tasks_possible_answers (theory_task_id, possible_answers_id)
values (7, 1);
insert into tasks_possible_answers (theory_task_id, possible_answers_id)
values (8, 2);
insert into tasks_task_items (option_task_id, task_items_id)
values (5, 1);
insert into tasks_task_items (option_task_id, task_items_id)
values (6, 2);