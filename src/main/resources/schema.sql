
drop schema IF EXISTS metadataio;

-- auto-generated definition
create schema metadataio collate utf8mb4_0900_ai_ci;

create table metadataio.course_sequence
(
    next_val bigint null
);

create table metadataio.courses
(
    id             bigint auto_increment
        primary key,
    name_course    varchar(50) not null,
    code_course    varchar(50) not null,
    number_student int         not null,
    constraint courses_code_course_uindex
        unique (code_course),
    constraint courses_id_uindex
        unique (id),
    constraint courses_name_course_uindex
        unique (name_course)
);

create table metadataio.student_course_sequence
(
    next_val bigint null
);

create table metadataio.student_sequence
(
    next_val bigint null
);

create table metadataio.students
(
    id        bigint auto_increment
        primary key,
    full_name varchar(200) not null,
    number_id bigint       not null,
    constraint students_id_uindex
        unique (id),
    constraint students_number_id_uindex
        unique (number_id)
);

create table metadataio.student_course
(
    id         bigint auto_increment
        primary key,
    student_id bigint not null,
    course_id  bigint not null,
    constraint students_course_id_uindex
        unique (id),
    constraint course_fk
        foreign key (course_id) references courses (id),
    constraint students_fk
        foreign key (student_id) references students (id)
);

