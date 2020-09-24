--- CREATING TABLES ---

create table chapters
(
    id        bigserial not null,
    name      varchar(255),
    position  int4,
    module_id int8,
    primary key (id)
);

create table courses
(
    id            bigserial not null,
    creating_time timestamp,
    description   varchar(255),
    html_body     varchar(255),
    is_available  boolean,
    name          varchar(255),
    teacher_id    int8,
    direction_id  int8,
    primary key (id)
);

create table directions
(
    id   bigserial not null,
    name varchar(255),
    primary key (id)
);

create table modules
(
    id          bigserial not null,
    description varchar(255),
    is_open     boolean,
    name        varchar(255),
    open_date   timestamp,
    position    int4,
    course_id   int8,
    primary key (id)
);

create table option_student_task_items
(
    id                            bigserial not null,
    position                      int4,
    option_task_student_answer_id int8,
    option_task_item_id           int8,
    primary key (id)
);

create table option_task_items
(
    id             bigserial not null,
    item_text      varchar(255),
    position       int4,
    option_task_id int8,
    primary key (id)
);

create table personal_student_courses
(
    id           bigserial not null,
    adding_date  timestamp,
    is_completed boolean,
    course_id    int8,
    user_id      int8,
    primary key (id)
);

create table personal_students_course_tasks
(
    id                         bigserial not null,
    is_completed               boolean,
    is_solved                  boolean,
    personal_student_course_id int8,
    task_id                    int8,
    primary key (id)
);

create table possible_answers
(
    id             bigserial not null,
    is_right       boolean,
    text           varchar(255),
    theory_task_id int8,
    primary key (id)
);

create table possible_student_task_answers
(
    id                            bigserial not null,
    text                          varchar(255),
    possible_answer_id            int8,
    theory_student_task_answer_id int8,
    primary key (id)
);

create table student_group_student
(
    student_group_id int8 not null,
    student_id       int8 not null,
    primary key (student_group_id, student_id)
);

create table student_groups
(
    id         bigserial not null,
    name       varchar(255),
    course_id  int8,
    teacher_id int8,
    primary key (id)
);

create table student_task_answers
(
    dtype                           varchar(31) not null,
    id                              bigserial   not null,
    date                            timestamp,
    is_right                        boolean,
    answer                          varchar(255),
    personal_student_course_task_id int8,
    possible_student_task_answer_id int8,
    primary key (id)
);

create table student_task_answers_option_student_task_answer_item
(
    option_task_student_answer_id      int8 not null,
    option_student_task_answer_item_id int8 not null
);

create table task_chapter
(
    task_id    int8 not null,
    chapter_id int8 not null,
    primary key (task_id, chapter_id)
);

create table tasks
(
    dtype        varchar(31) not null,
    id           bigserial   not null,
    description  varchar(255),
    is_available boolean,
    name         varchar(255),
    points       int4,
    position     int4,
    type         varchar(255),
    answer       varchar(255),
    primary key (id)
);

create table tasks_possible_answers
(
    theory_task_id      int8 not null,
    possible_answers_id int8 not null
);

create table tasks_task_items
(
    option_task_id int8 not null,
    task_items_id  int8 not null
);

create table users
(
    dtype             varchar(31) not null,
    id                bigserial   not null,
    email             varchar(255),
    enabled           boolean,
    first_name        varchar(255),
    last_name         varchar(255),
    password          varchar(255),
    registration_date timestamp,
    primary key (id)
);

--- ALTERING TABLES ---
alter table if exists student_task_answers_option_student_task_answer_item
    add constraint UK_jlrm4wivwkunvypgbiha2q0v6 unique (option_student_task_answer_item_id);

alter table if exists tasks_possible_answers
    add constraint UK_oq14p526cp96pcf46hix07dbv unique (possible_answers_id);

alter table if exists tasks_task_items
    add constraint UK_6on02916uiib3getq2wpcp543 unique (task_items_id);

alter table if exists chapters
    add constraint FK44e0ctk7iiss9j8dm6tf5v1ci foreign key (module_id) references modules;

alter table if exists courses
    add constraint FKt4ba5fab1x56tmt4nsypv5lm5 foreign key (teacher_id) references users;

alter table if exists courses
    add constraint FK5pmfwoy29m39xwl2jy4qqchny foreign key (direction_id) references directions;

alter table if exists modules
    add constraint FK8qnnp812q1jd38fx7mxrhpw9 foreign key (course_id) references courses;

alter table if exists option_student_task_items
    add constraint FKr62w61pd06dpd6737n8jwesor foreign key (option_task_student_answer_id) references student_task_answers;

alter table if exists option_student_task_items
    add constraint FKmhncxna8ctx3euuyqvrqkwkvi foreign key (option_task_item_id) references option_task_items;

alter table if exists option_task_items
    add constraint FKc91k3h0rvrvxrvt1098l9qmnx foreign key (option_task_id) references tasks;

alter table if exists personal_student_courses
    add constraint FKbjagss1vdgtwtmkh3xpjuhxap foreign key (course_id) references courses;

alter table if exists personal_student_courses
    add constraint FKk0gb2008odfkmf1rcfsf6jobw foreign key (user_id) references users;

alter table if exists personal_students_course_tasks
    add constraint FKbasdskrnlnrboyo17vjraxy6w foreign key (personal_student_course_id) references personal_student_courses;

alter table if exists personal_students_course_tasks
    add constraint FKf6tnexyct1wg4cv63sfta3138 foreign key (task_id) references tasks;

alter table if exists possible_answers
    add constraint FK5jiix68d7hxnr6ise2c3tm29w foreign key (theory_task_id) references tasks;

alter table if exists possible_student_task_answers
    add constraint FKg0wxp0b2y39v9qm05te8bof5i foreign key (possible_answer_id) references possible_answers;

alter table if exists possible_student_task_answers
    add constraint FKkl1c52rgslaarhryhrjofbfd6 foreign key (theory_student_task_answer_id) references student_task_answers;

alter table if exists student_group_student
    add constraint FKqq9tcfshp0mhaxq8lcqdnt3vq foreign key (student_id) references users;

alter table if exists student_group_student
    add constraint FKkssya0y0b07b9t7bgbggpg6ea foreign key (student_group_id) references student_groups;

alter table if exists student_groups
    add constraint FKccvmcei91ieg9ec11kltcvvix foreign key (course_id) references courses;

alter table if exists student_groups
    add constraint FKd5ffsviyw7x3epsi2v0e2kndk foreign key (teacher_id) references users;

alter table if exists student_task_answers
    add constraint FK764otfqwl41d5ap0qslvc5ift foreign key (personal_student_course_task_id) references personal_students_course_tasks;

alter table if exists student_task_answers
    add constraint FK9kf4uerl9kjqgwrhg1jc7xkuy foreign key (possible_student_task_answer_id) references possible_student_task_answers;

alter table if exists student_task_answers_option_student_task_answer_item
    add constraint FK78lx4b7nd0dmyktm1805hy4jy foreign key (option_student_task_answer_item_id) references option_student_task_items;

alter table if exists student_task_answers_option_student_task_answer_item
    add constraint FKbgmpx4u8pf7h3fww5j44kdj2l foreign key (option_task_student_answer_id) references student_task_answers;

alter table if exists task_chapter
    add constraint FKjr3lj4pd33dtvpfq3th2rpm3a foreign key (chapter_id) references chapters;

alter table if exists task_chapter
    add constraint FKa3w5iwdev7ec798k9dk085o44 foreign key (task_id) references tasks;

alter table if exists tasks_possible_answers
    add constraint FKlp9xbma6qe21joaqg7wwsdust foreign key (possible_answers_id) references possible_answers;

alter table if exists tasks_possible_answers
    add constraint FKar1lrt210g44b8do2xowspyyg foreign key (theory_task_id) references tasks;

alter table if exists tasks_task_items
    add constraint FKpixxtq8ejhoyclosqacwbfnl8 foreign key (task_items_id) references option_task_items;

alter table if exists tasks_task_items
    add constraint FK6uhv35r47g8jrefpeiyqvj2ba foreign key (option_task_id) references tasks;