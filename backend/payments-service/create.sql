create table memberships (id  serial not null, active boolean not null, final_date date, start_date date, type_id int2 not null, primary key (id))
create table memberships_type (id  serial not null, cost float8 not null, name varchar(255), primary key (id))
create table payments (id  bigserial not null, amount float8 not null, date date, user_id varchar(255) not null, primary key (id))
create table reservations (id  serial not null, date timestamp, final_hour time, start_hour time, primary key (id))
create table roles (id  serial not null, name varchar(255), primary key (id))
create table users (identification_number varchar(255) not null, active boolean not null, address varchar(255), coach_id varchar(255), email varchar(255), last_names varchar(255), membership_id int2, names varchar(255), password varchar(255), phone_number varchar(255), photo varchar(255), role_id int4, primary key (identification_number))
create table users_reservations (id  serial not null, active boolean not null, reservation_id int4, user_id varchar(255), primary key (id))
alter table if exists users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table if exists memberships add constraint FKt4iv2xqgbku7pp6vi24ksyl0m foreign key (type_id) references memberships_type
alter table if exists payments add constraint FKj94hgy9v5fw1munb90tar2eje foreign key (user_id) references users
alter table if exists users add constraint FKh8k0vg5q0v25p9vgkbuf6o4xa foreign key (coach_id) references users
alter table if exists users add constraint FKd8u6qiogyr0w5vfkohbn44gtl foreign key (membership_id) references memberships
alter table if exists users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles
alter table if exists users_reservations add constraint FK2yebdmfayjpqnoaeedc93luqn foreign key (reservation_id) references reservations
alter table if exists users_reservations add constraint FKbjbk2fls1rddtmi8wmswquatu foreign key (user_id) references users
INSERT INTO `payments` (amount , date , user_id) VALUES(45000 , '2021-05-29' , '1122122653')
