drop table if exists customer;

create table customer
(
    id         uuid primary key,
    name       varchar not null,
    password   varchar not null,
    first_name varchar not null,
    last_name  varchar not null
);