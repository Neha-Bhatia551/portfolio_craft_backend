create table if not exists usertable
(
    id SERIAL PRIMARY KEY,
    username varchar(255) not null
);