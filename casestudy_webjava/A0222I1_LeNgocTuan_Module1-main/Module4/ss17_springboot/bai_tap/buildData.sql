create database if not exists baitaps17;
use baitaps17;
create table produce(
id int primary key,
`name` varchar(40),
date_to_use date,
nation varchar(40),
avatar varchar(40),
color varchar(40),
promote boolean
);

insert into produce values(42,"pen","2022-11-12","USA","pen.jpg","red", true);
insert into produce values(41,"ruler","2022-11-12","VN","ruler.png","white", false);
insert into produce values(11,"pencil","2023-01-12","VN","pencil.jpg","black", false);