--- CREATING TABLES ---

create table chapter (
    id bigserial not null,
    name varchar(255),
    position int4,
    module_id int8,
    primary key (id)
);
create table course (
    id bigserial not null,
    about_teacher_info varchar(255),
    creating_time timestamp,
    html_body varchar(255),
    is_available boolean,
    name varchar(255),
    direction_id int8,
    primary key (id)
);

create table course_info (
    id bigserial not null,
    about varchar(255),
    description varchar(255),
    course_id int8,
    teacher_id int8,
    primary key (id)
);

create table course_task (
    id bigserial not null,
    position int4,
    chapter_id int8,
    task_id int8,
    primary key (id)
);

create table custom_answer (
    id bigserial not null,
    text varchar(255),
    primary key (id)
);

create table direction (
    id bigserial not null,
    name varchar(255),
    primary key (id)
);

create table module (
    id bigserial not null,
    description varchar(255),
    is_open boolean,
    name varchar(255),
    open_date date,
    position int4,
    course_id int8,
    primary key (id)
);

create table ordering_task_answer_item (
    id bigserial not null,
    position int4,
    ordering_task_item_id int8,
    probably_answer_id int8,
    student_course_task_answer_id int8,
    primary key (id)
);

create table ordering_task_item (
    id bigserial not null,
    item_text varchar(255),
    position int4,
    ordering_task_id int8,
    primary key (id)
);

create table probably_answer (
    id bigserial not null,
    is_right boolean,
    text varchar(255),
    theory_task_id int8,
    primary key (id)
);

create table student_course_info (
    id bigserial not null,
    adding_date timestamp,
    is_completed boolean,
    course_id int8,
    user_id int8,
    primary key (id)
);

create table student_course_info_student_course_tasks (
    student_course_info_id int8 not null,
    student_course_tasks_id int8 not null
);

create table student_course_task (
    id bigserial not null,
    is_reset boolean,
    is_right boolean,
    is_solved boolean,
    is_wrong boolean,
    course_task_id int8,
    student_course_info_id int8,
    primary key (id)
);

create table student_course_task_student_course_task_answers (
    student_course_task_id int8 not null,
    student_course_task_answers_id int8 not null
);

create table student_course_task_answer (
    id bigserial not null,
    answer varchar(255),
    date timestamp,
    is_right boolean,
    custom_answer_id int8,
    ordering_task_answer_item_id int8,
    student_course_task_id int8, primary key (id)
);

create table student_course_task_answer_student_course_task_answers (
    student_course_task_answer_id int8 not null,
    student_course_task_answers_id int8 not null
);

create table student_group (
    id bigserial not null,
    name varchar(255),
    course_id int8,
    teacher_id int8,
    primary key (id)
);

create table task (
    dtype varchar(31) not null,
    id bigserial not null,
    description varchar(255),
    is_available boolean,
    points int4,
    title varchar(255),
    type varchar(255),
    answer varchar(255),
    primary key (id)
);

create table task_probably_answers (
    theory_task_id int8 not null,
    probably_answers_id int8 not null
);

create table task_task_items (
    ordering_task_id int8 not null,
    task_items_id int8 not null
);

create table users (
    dtype varchar(31) not null,
    id bigserial not null,
    email varchar(255),
    enabled boolean,
    first_name varchar(255),
    last_name varchar(255),
    password varchar(255),
    registration_date timestamp,
    role bytea,
    primary key (id)
);

--- ALTERING TABLES ---

alter table if exists student_course_info_student_course_tasks
    add constraint UK_5roh373lk3ohs9ol625raod9s
    unique (student_course_tasks_id);

alter table if exists student_course_task_student_course_task_answers
    add constraint UK_ci1nt8udxvj3qmthtxemspv73
    unique (student_course_task_answers_id);

alter table if exists student_course_task_answer_student_course_task_answers
    add constraint UK_1ok176pei6oujiwpq9effucdr
    unique (student_course_task_answers_id);

alter table if exists task_probably_answers
    add constraint UK_6li5rq4vmgntph1e97rg3lsb7
    unique (probably_answers_id);

alter table if exists task_task_items
    add constraint UK_5f687b1odg7n9rhlh3i3ehdlq
    unique (task_items_id);

alter table if exists chapter
    add constraint FK64w3jdivg2rkupnm9oxptv5x3
    foreign key (module_id)
    references module;

alter table if exists course
    add constraint FKp8ui0dq57cwlujqhir5ekuw7a
    foreign key (direction_id)
    references direction;

alter table if exists course_info
    add constraint FKh8vciy6bmbkpol1d4qsyp6ovk
    foreign key (course_id)
    references course;

alter table if exists course_info
    add constraint FK919rhxlnkndka8p2rgkdfi8dg
    foreign key (teacher_id)
    references users;

alter table if exists course_task
    add constraint FK6o0extv2offafg84vj5tyr2pb
    foreign key (chapter_id)
    references chapter;

alter table if exists course_task
    add constraint FKa9s55il467vox5hichk9uu5r
    foreign key (task_id)
    references task;

alter table if exists module
    add constraint FKfq09oddpwjoxcirvkh9vnfnsg
    foreign key (course_id)
    references course;

alter table if exists ordering_task_answer_item
    add constraint FKmucprpjv3vmsjps6cdyw13a3d
    foreign key (ordering_task_item_id)
    references ordering_task_item;

alter table if exists ordering_task_answer_item
    add constraint FK7wwg8gtgrah5pxo86pmlms5ei
    foreign key (probably_answer_id)
    references probably_answer;

alter table if exists ordering_task_answer_item
    add constraint FKtpbrghu3q3u4xgrwfo3awshb3
    foreign key (student_course_task_answer_id)
    references student_course_task_answer;

alter table if exists ordering_task_item
    add constraint FK4i9xd7ebb0cmxt7nf1vd6tpa7
    foreign key (ordering_task_id)
    references task;

alter table if exists probably_answer
    add constraint FKbqeokmtan8xvcmtur8cecdsf
    foreign key (theory_task_id)
    references task;

alter table if exists student_course_info
    add constraint FK34w26vfj0hrcfox75ao2nlbay
    foreign key (course_id)
    references course;

alter table if exists student_course_info
    add constraint FK9gnm2xkhuh570p9da8grdf4gk
    foreign key (user_id)
    references users;

alter table if exists student_course_info_student_course_tasks
    add constraint FKatdgkn8gr5cs59xxqrtro8uwi
    foreign key (student_course_tasks_id)
    references student_course_task;

alter table if exists student_course_info_student_course_tasks
    add constraint FKd2dlvxhhna97ppbncimko87l0
    foreign key (student_course_info_id)
    references student_course_info;

alter table if exists student_course_task
    add constraint FKbgl9e4gn5pf63dmcv5l3vweno
    foreign key (course_task_id)
    references course_task;

alter table if exists student_course_task
    add constraint FK10ghogdeqv50q9grg5ij3rdm6
    foreign key (student_course_info_id)
    references student_course_info;

alter table if exists student_course_task_student_course_task_answers
    add constraint FKi7x665h1oi1im4210ytnbqoih
    foreign key (student_course_task_answers_id)
    references student_course_task_answer;

alter table if exists student_course_task_student_course_task_answers
    add constraint FKadw2gcryj52au83tijjrpsnrq
    foreign key (student_course_task_id)
    references student_course_task;

alter table if exists student_course_task_answer
    add constraint FK9h0d6xarf2l0uapq9fuk7ntw6
    foreign key (custom_answer_id)
    references custom_answer;

alter table if exists student_course_task_answer
    add constraint FKh7xaykv03aoke29025880ix3m
    foreign key (ordering_task_answer_item_id)
    references ordering_task_answer_item;

alter table if exists student_course_task_answer
    add constraint FK60trto6g29unv7il52ksec1nq
    foreign key (student_course_task_id)
    references student_course_task;

alter table if exists student_course_task_answer_student_course_task_answers
    add constraint FK3pjvw5a6i0v8wsm8fi009q7ra
    foreign key (student_course_task_answers_id)
    references student_course_task_answer;

alter table if exists student_course_task_answer_student_course_task_answers
    add constraint FKi39sboapuuwmpnk6dbie0q6m6
    foreign key (student_course_task_answer_id)
    references student_course_task_answer;

alter table if exists student_group
    add constraint FKlx1j4yvkh8u0hsq8k3eblghqo
    foreign key (course_id)
    references course;

alter table if exists student_group
    add constraint FKmecm6d5as8evnv346o97f7iv1
    foreign key (teacher_id)
    references users;

alter table if exists task_probably_answers
    add constraint FK58ufu4ywjovt5uvn8xx8kk4us
    foreign key (probably_answers_id)
    references probably_answer;

alter table if exists task_probably_answers
    add constraint FK8asdvojw6hb5erm1ecrttcxwf
    foreign key (theory_task_id)
    references task;

alter table if exists task_task_items
    add constraint FK2jprc9slqp7h1dvc9codmeddb
    foreign key (task_items_id)
    references ordering_task_item;

alter table if exists task_task_items
    add constraint FKju2fh1802jbrmct0s4pq38d5x
    foreign key (ordering_task_id)
    references task;