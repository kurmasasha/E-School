create sequence hibernate_sequence start 1 increment 1;

create table chapter (
    id_chapter int8 not null,
    name varchar(255),
    position int4,
    id_module int8,
    primary key (id_chapter)
);

create table course (
    id_course int8 not null,
    about_teacher_info varchar(255),
    creating_time timestamp,
    html_body varchar(255),
    is_available boolean,
    name varchar(255),
    id_direction int8,
    primary key (id_course)
);

create table course_info (
    id int8 not null,
    about varchar(255),
    description varchar(255),
    id_course int8,
    id_teacher int8,
    primary key (id)
);

create table course_task (
    id_course_task int8 not null,
    position int4,
    id_chapter int8,
    id_task int8,
    primary key (id_course_task)
);

create table custom_answer (
    id_custom_answer int8 not null,
    text varchar(255),
    primary key (id_custom_answer)
);

create table direction (
    id_direction int8 not null,
    name varchar(255),
    primary key (id_direction)
);

create table module (
    id_module int8 not null,
    description varchar(255),
    is_open boolean,
    name varchar(255),
    open_date date,
    position int4,
    id_course int8,
    primary key (id_module)
);

create table ordering_task_answer_item (
    id_ordering_task_answer_item int8 not null,
    position int4,
    id_ordering_task_item int8,
    id_probably_answer int8,
    student_course_task_answer_id int8,
    primary key (id_ordering_task_answer_item)
);

create table ordering_task_item (
    id_ordering_task_item int8 not null,
    item_text varchar(255),
    position int4,
    id_task int8,
    primary key (id_ordering_task_item)
);

create table probably_answer (
    id_probably_answer int8 not null,
    right boolean,
    text varchar(255),
    id_task int8,
    primary key (id_probably_answer)
);

create table student_course_info (
    id_student_course_info int8 not null,
    adding_date timestamp,
    is_completed boolean,
    id_course int8,
    id_user int8,
    primary key (id_student_course_info)
);

create table student_course_info_student_course_tasks (
    student_course_info_id_student_course_info int8 not null,
    student_course_tasks_id_student_course_task int8 not null
);

create table student_course_task (
    id_student_course_task int8 not null,
    is_reset boolean,
    is_right boolean,
    is_solved boolean,
    is_wrong boolean,
    id_course_task int8,
    id_student_course_info int8,
    primary key (id_student_course_task)
);

create table student_course_task_student_course_task_answers (
    student_course_task_id_student_course_task int8 not null,
    student_course_task_answers_id int8 not null
);

create table student_course_task_answer (
    id int8 not null,
    answer varchar(255),
    date timestamp,
    is_right boolean,
    id_custom_answer int8,
    id_ordering_task_answer_item int8,
    id_student_course_task int8,
    primary key (id)
);

create table student_course_task_answer_student_course_task_answers (
    student_course_task_answer_id int8 not null,
    student_course_task_answers_id int8 not null
);

create table student_group (
    id_student_group int8 not null,
    name varchar(255),
    id_course int8,
    id_user int8,
    primary key (id_student_group)
);

create table task (
    dtype varchar(31) not null,
    id_task int8 not null,
    description varchar(255),
    is_available boolean,
    points int4,
    title varchar(255),
    type varchar(255),
    answer varchar(255),
    primary key (id_task)
);

create table task_probably_answers (
    theory_task_id_task int8 not null,
    probably_answers_id_probably_answer int8 not null
);

create table task_task_items (
    ordering_task_id_task int8 not null,
    task_items_id_ordering_task_item int8 not null
);

create table users (
    dtype varchar(31) not null,
    id int8 not null,
    email varchar(255),
    enabled boolean,
    first_name varchar(255),
    last_name varchar(255),
    password varchar(255),
    registration_date timestamp,
    role bytea,
    primary key (id)
);

alter table student_course_info_student_course_tasks
    add constraint UK_eidkpjqm32m6oidrg5u4dkc09
    unique (student_course_tasks_id_student_course_task);

alter table student_course_task_student_course_task_answers
    add constraint UK_ci1nt8udxvj3qmthtxemspv73
    unique (student_course_task_answers_id);

alter table student_course_task_answer_student_course_task_answers
    add constraint UK_1ok176pei6oujiwpq9effucdr
    unique (student_course_task_answers_id);

alter table task_probably_answers
    add constraint UK_tdy4a1i26h4srj4gbp6lbbqaq
    unique (probably_answers_id_probably_answer);

alter table task_task_items
    add constraint UK_mkcx79y7gp9i7v4qt2un5xokk
    unique (task_items_id_ordering_task_item);

alter table chapter
    add constraint FKr3nes27eksnxceue92o2wbkj8
    foreign key (id_module)
    references module;

alter table course
    add constraint FKfh9lxmy26qbq5813l68ivwifl
    foreign key (id_direction)
    references direction;

alter table course_info
    add constraint FKmq9ucx8ves2s0atiniw3ao4p8
    foreign key (id_course)
    references course;

alter table course_info
    add constraint FKfjbufb026jl1iufm3pvlt8nlp
    foreign key (id_teacher)
    references users;

alter table course_task
    add constraint FKcaadmbaotx5fpcc7fva1da4i9
    foreign key (id_chapter)
    references chapter;

alter table course_task
    add constraint FK9j5ln0g2splvkodo5swnrhau7
    foreign key (id_task)
    references task;

alter table module
    add constraint FK5yx9t4pivui02sh0fccox2eic
    foreign key (id_course)
    references course;

alter table ordering_task_answer_item
    add constraint FK4rndnsrgxurkvqflp2j64pmjr
    foreign key (id_ordering_task_item)
    references ordering_task_item;

alter table ordering_task_answer_item
    add constraint FKem6qqe6ymboujmjnk7p8qqk46
    foreign key (id_probably_answer)
    references probably_answer;

alter table ordering_task_answer_item
    add constraint FKtpbrghu3q3u4xgrwfo3awshb3
    foreign key (student_course_task_answer_id)
    references student_course_task_answer;

alter table ordering_task_item
    add constraint FKolke0uf4svbusxglal0xcv22t
    foreign key (id_task)
    references task;

alter table probably_answer
    add constraint FKne8g7xdhuydt8qsgtm2w14nf4
    foreign key (id_task)
    references task;

alter table student_course_info
    add constraint FKdpkmn4xfldrsioxky91ujxsr
    foreign key (id_course)
    references course;

alter table student_course_info
    add constraint FK1du0h3fxjpj8h6p84v4muf16p
    foreign key (id_user)
    references users;

alter table student_course_info_student_course_tasks
    add constraint FKndtggy4lrbi45irmaonlm1ru4
    foreign key (student_course_tasks_id_student_course_task)
    references student_course_task;

alter table student_course_info_student_course_tasks
    add constraint FK54sray20ov8dytpwg30s11nfr
    foreign key (student_course_info_id_student_course_info)
    references student_course_info;

alter table student_course_task
    add constraint FK9pxw49rd1vun1ajpg5ctnv62k
    foreign key (id_course_task)
    references course_task;

alter table student_course_task
    add constraint FKb1h1vwpcc98ugj558qivq7em3
    foreign key (id_student_course_info)
    references student_course_info;

alter table student_course_task_student_course_task_answers
    add constraint FKi7x665h1oi1im4210ytnbqoih
    foreign key (student_course_task_answers_id)
    references student_course_task_answer;

alter table student_course_task_student_course_task_answers
    add constraint FKbx3aj0obmres7m8n6mdtcb9fh
    foreign key (student_course_task_id_student_course_task)
    references student_course_task;

alter table student_course_task_answer
    add constraint FK4sjigcwvt4aelnfy7vajwl4hk
    foreign key (id_custom_answer)
    references custom_answer;

alter table student_course_task_answer
    add constraint FKr7o8hvdre3dxqwe47ym9vb2d3
    foreign key (id_ordering_task_answer_item)
    references ordering_task_answer_item;

alter table student_course_task_answer
    add constraint FKpn86p4qiqiewvje82flpa2tky
    foreign key (id_student_course_task)
    references student_course_task;

alter table student_course_task_answer_student_course_task_answers
    add constraint FK3pjvw5a6i0v8wsm8fi009q7ra
    foreign key (student_course_task_answers_id)
    references student_course_task_answer;

alter table student_course_task_answer_student_course_task_answers
    add constraint FKi39sboapuuwmpnk6dbie0q6m6
    foreign key (student_course_task_answer_id)
    references student_course_task_answer;

alter table student_group
    add constraint FKh6m1evjxouwyymr14nt5t5h0l
    foreign key (id_course)
    references course;

alter table student_group
    add constraint FKq8twursgg2nmu4r2umsuksp2m
    foreign key (id_user)
    references users;

alter table task_probably_answers
    add constraint FKj87g4u8dny2ylhqo0h3t7q78h
    foreign key (probably_answers_id_probably_answer)
    references probably_answer;

alter table task_probably_answers
    add constraint FKsfc3e51g5ox9ux28iq3f8idyw
    foreign key (theory_task_id_task)
    references task;

alter table task_task_items
    add constraint FKleor6bwbln61oqpccdhih00ee
    foreign key (task_items_id_ordering_task_item)
    references ordering_task_item;

alter table task_task_items
    add constraint FK6vlwevchjrh93jmoaubuubyal
    foreign key (ordering_task_id_task)
    references task;