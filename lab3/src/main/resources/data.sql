insert into users (id, name)
values (100, 'Madhav');

insert into posts (content, title, user_id, author)
values ('content 1', 'title 1', 100, 'author 1');
insert into posts (content, title, user_id, author)
values ('content 2', 'title 2', 100, 'author 2');
insert into posts (content, title, user_id, author)
values ('content 3', 'title 3', 100, 'author 3');

-- insert into comment (id, name, post_id)
-- values (1, 'post 1 comments', 1);
-- insert into comment (id, name, post_id)
-- values (1, 'post 2 comments', 1);
-- insert into comment (id, name, post_id)
-- values (1, 'post 3 comments', 1);
-- insert into comment (id, name, post_id)
-- values (1, 'post 4 comments', 1);