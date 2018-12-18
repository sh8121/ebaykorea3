insert into member (id, name, password, email, regdate) values(1, '김성박', '{bcrypt}$2a$10$ZEulp8wVXy7eTuQiMqeyn.XqXSpV2xq/587PUSpu0lIghw7rsMvK2', 'urstory@gmail.com', now());
insert into member (id, name, password, email, regdate) values(2, '강경미', '{bcrypt}$2a$10$ZEulp8wVXy7eTuQiMqeyn.XqXSpV2xq/587PUSpu0lIghw7rsMvK2', 'carami@gmail.com', now());
insert into role (id,  name) values (1, 'MEMBER');
insert into role (id,  name) values (2, 'ADMIN');

insert into member_role(member_id, role_id) values( 1, 1);
insert into member_role(member_id, role_id) values( 1, 2);
insert into member_role(member_id, role_id) values( 2, 1);

insert into item_category(id, name, orders, parent_id) values(1, "솔루션", 0, null);
insert into item_category(id, name, orders, parent_id) values(2, "언어", 1, null);
insert into item_category(id, name, orders, parent_id) values(3, "IDE", 0, 1);
insert into item_category(id, name, orders, parent_id) values(4, "DataTool", 1, 1);
insert into item_category(id, name, orders, parent_id) values(5, "HighLevel", 0, 2);
insert into item_category(id, name, orders, parent_id) values(6, "LowLevel", 1, 2);

insert into item(id, content, name, price, reg_date, item_category_id) values(1, "Microsoft특화솔루션입니다.", "VisualStudio", 150000, now(), 3);
insert into item(id, content, name, price, reg_date, item_category_id) values(2, "Jetbrain의 야심작입니다.", "Intellij", 450000, now(), 3);
insert into item(id, content, name, price, reg_date, item_category_id) values(3, "빅데이터 분석 Tool입니다.", "ApacheSpark", 950000, now(), 4);
insert into item(id, content, name, price, reg_date, item_category_id) values(4, "Web Client 제어 언어입니다.", "Javascript", 1000, now(), 5);
insert into item(id, content, name, price, reg_date, item_category_id) values(5, "All Round Player 언어!", "Java", 10000, now(), 5);
insert into item(id, content, name, price, reg_date, item_category_id) values(6, "잘몰라요", "Assembly", 100000, now(), 6);
insert into item(id, content, name, price, reg_date, item_category_id) values(7, "대학교때 이거부터 배워요.", "C", 20000, now(), 6);