insert into member (id, name, password, email, regdate) values(1, '김성박', '{bcrypt}$2a$10$ZEulp8wVXy7eTuQiMqeyn.XqXSpV2xq/587PUSpu0lIghw7rsMvK2', 'urstory@gmail.com', now());
insert into member (id, name, password, email, regdate) values(2, '강경미', '{bcrypt}$2a$10$ZEulp8wVXy7eTuQiMqeyn.XqXSpV2xq/587PUSpu0lIghw7rsMvK2', 'carami@gmail.com', now());
insert into role (id,  name) values (1, 'MEMBER');
insert into role (id,  name) values (2, 'ADMIN');

insert into member_role(member_id, role_id) values( 1, 1);
insert into member_role(member_id, role_id) values( 1, 2);
insert into member_role(member_id, role_id) values( 2, 1);
