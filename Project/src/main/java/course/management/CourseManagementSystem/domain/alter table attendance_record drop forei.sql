alter table attendance_record drop foreign key FKnqwuidhqd7xfyrhs5b2ohgobo;
alter table attendance_record drop foreign key FK9p10lf3n7tcuouo29ery5obq6;
alter table course_offering drop foreign key FK9k36i31hofp7tesccjwcgh7hk;
alter table course_offering drop foreign key FKja7uogvk4f9dmd0cegpxkvad1;
alter table course_prerequisite drop foreign key FK7ymu65b28wpw2opjmrx7hsbxl;
alter table course_prerequisite drop foreign key FK45vm6hef5h141uiu8qeod3wcg;
alter table course_registration drop foreign key FK1dnio69sc4296s6nwwysdmmjt;
alter table course_registration drop foreign key FKi5hvb7p3dafd9qd3k3eyeyann;
alter table faculty drop foreign key FKbaddwwp9t5jrbpuja8snx3f99;
alter table faculty_hobby drop foreign key FKosarklq8v3krd3mj5319q9s0d;
alter table location drop foreign key FK3l2oelpu05dyarlppuv42vu0p;
alter table person drop foreign key FKjp7pg0ofouxr3ydly9rxh511u;
alter table student drop foreign key FKhf91r1aq4qnlldujfb10x61yp;
alter table student drop foreign key FKslayvtom01idjdexcxh76k935;
drop table if exists attendance_record;
drop table if exists course;
drop table if exists course_offering;
drop table if exists course_prerequisite;
drop table if exists course_registration;
drop table if exists faculty;
drop table if exists faculty_hobby;
drop table if exists location;
drop table if exists location_type;
drop table if exists person;
drop table if exists person_account;
drop table if exists student;
create table attendance_record (ScanDateTime date, id bigint not null auto_increment, location_id bigint, student_id bigint, primary key (id)) engine=InnoDB;
create table course (created_on datetime(6), id bigint not null auto_increment, updated_on datetime(6), course_code varchar(255), course_description varchar(255), course_name varchar(255), created_by varchar(255), credits varchar(255), department varchar(255), updated_by varchar(255), primary key (id)) engine=InnoDB;
create table course_offering (capacity integer not null, course_offering_type tinyint, courseid bigint, created_on datetime(6), facultyid bigint, id bigint not null auto_increment, updated_on datetime(6), created_by varchar(255), credits varchar(255), room varchar(255), updated_by varchar(255), primary key (id)) engine=InnoDB;
create table course_prerequisite (course_id bigint not null, prerequisite_id bigint not null) engine=InnoDB;
create table course_registration (course_offering_id bigint not null, student_id bigint not null) engine=InnoDB;
create table faculty (id bigint not null, salutation varchar(255), primary key (id)) engine=InnoDB;
create table faculty_hobby (faculty_id bigint, id bigint not null auto_increment, hobbies varchar(255), primary key (id)) engine=InnoDB;
create table location (capacity integer, created_on datetime(6), id bigint not null auto_increment, type_id bigint, updated_on datetime(6), created_by varchar(255), name varchar(255), updated_by varchar(255), primary key (id)) engine=InnoDB;
create table location_type (created_on datetime(6), id bigint not null auto_increment, updated_on datetime(6), created_by varchar(255), type varchar(255), updated_by varchar(255), primary key (id)) engine=InnoDB;
create table person (birthdate date, gender_type tinyint, created_on datetime(6), id bigint not null auto_increment, person_account_id bigint, updated_on datetime(6), created_by varchar(255), email_address varchar(255), first_name varchar(255), last_name varchar(255), updated_by varchar(255), primary key (id)) engine=InnoDB;
create table person_account (id bigint not null auto_increment, password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table student (faculty_adviserid bigint, id bigint not null, alternateid varchar(255), applicantid varchar(255), entry varchar(255), studentid varchar(255), primary key (id)) engine=InnoDB;
alter table person add constraint UKsxena0hmeefciv3uqijckfcbs unique (person_account_id);
alter table attendance_record add constraint FKnqwuidhqd7xfyrhs5b2ohgobo foreign key (location_id) references location (id);
alter table attendance_record add constraint FK9p10lf3n7tcuouo29ery5obq6 foreign key (student_id) references student (id);
alter table course_offering add constraint FK9k36i31hofp7tesccjwcgh7hk foreign key (courseid) references course (id);
alter table course_offering add constraint FKja7uogvk4f9dmd0cegpxkvad1 foreign key (facultyid) references faculty (id);
alter table course_prerequisite add constraint FK7ymu65b28wpw2opjmrx7hsbxl foreign key (prerequisite_id) references course (id);
alter table course_prerequisite add constraint FK45vm6hef5h141uiu8qeod3wcg foreign key (course_id) references course (id);
alter table course_registration add constraint FK1dnio69sc4296s6nwwysdmmjt foreign key (course_offering_id) references course (id);
alter table course_registration add constraint FKi5hvb7p3dafd9qd3k3eyeyann foreign key (student_id) references student (id);
alter table faculty add constraint FKbaddwwp9t5jrbpuja8snx3f99 foreign key (id) references person (id);
alter table faculty_hobby add constraint FKosarklq8v3krd3mj5319q9s0d foreign key (faculty_id) references faculty (id);
alter table location add constraint FK3l2oelpu05dyarlppuv42vu0p foreign key (type_id) references location_type (id);
alter table person add constraint FKjp7pg0ofouxr3ydly9rxh511u foreign key (person_account_id) references person_account (id);
alter table student add constraint FKhf91r1aq4qnlldujfb10x61yp foreign key (faculty_adviserid) references faculty (id);
alter table student add constraint FKslayvtom01idjdexcxh76k935 foreign key (id) references person (id)