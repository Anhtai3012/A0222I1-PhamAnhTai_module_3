create database if not exists codegym;

use codegym;

create table classes(
id int,
`name` varchar(50)
);

create table teacher(
id int,
`name` varchar(50),
age int,
country varchar(50)
);

insert into classes values (1,"A0222I1"), (2,"A0222I2");

insert into classes values(1,"A Chanh", 38, "VN"),(1,"A Quoc", 35, "VN");