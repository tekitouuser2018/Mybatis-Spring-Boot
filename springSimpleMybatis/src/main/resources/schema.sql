drop table if exists book;
create table if not exists book (
    id serial primary key,
    title varchar(50)
);