create database if not exists ss2_erd;

use ss2_erd;

create table customer(
c_id int primary key,
c_name varchar(50),
c_age int
);

create table orders(
o_id int primary key,
c_id int,
o_date datetime,
o_total_price int,
constraint fk_o_c foreign key(c_id) references customer(c_id)
);

create table produce(
p_id int primary key,
p_name varchar(50),
p_price int
);


create table orders_details(
o_id int primary key,
p_id int,
od_qty varchar(50),
constraint fk_od_o foreign key(o_id) references orders(o_id),
constraint fk_od_p foreign key(p_id) references produce(p_id)
);

drop database ss2_erd;


