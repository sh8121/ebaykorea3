insert into member (id, name, email, password, regdate)
values( 1, 'kim', 'urstory@gmail.com', '1234', now());

insert into member (id, name, email, password, regdate)
values( 2, 'kang', 'carami@gmail.com', '1234', now());

insert into role (id, name) values (1, 'USER');
insert into role (id, name) values (2, 'ADMIN');

insert into member_role(member_id, role_id) values(1, 1);
insert into member_role(member_id, role_id) values(1, 2);
insert into member_role(member_id, role_id) values(2, 1);

insert into board(id, member_id, title, create_date, read_count)
values(1, 1, 'hello 1', now(), 0);
insert into board(id, member_id, title, create_date, read_count)
values(2, 2, 'hello 2', now(), 0);
insert into board(id, member_id, title, create_date, read_count)
values(3, 1, 'hello 3', now(), 0);
insert into board(id, member_id, title, create_date, read_count)
values(4, 1, 'hello 4', now(), 0);
insert into board(id, member_id, title, create_date, read_count)
values(5, 1, 'hello 5', now(), 0);

insert into board_content(id, board_id, content) values (1, 1, 'content 1');
insert into board_content(id, board_id, content) values (2, 2, 'content 2');
insert into board_content(id, board_id, content) values (3, 3, 'content 3');
insert into board_content(id, board_id, content) values (4, 4, 'content 4');
insert into board_content(id, board_id, content) values (5, 5, 'content 5');