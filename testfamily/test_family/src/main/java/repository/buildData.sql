create database if not exists test_household;

use test_household;
create table household(
id varchar(50) primary key,
`name` varchar(50),
date_create date,
address varchar(50)
);

create table people(
id int auto_increment primary key,
cmnd varchar(50),
`name` varchar(50),
birthday date
);

create table people_live_house(
house_id varchar(50),
people_id int unique,
foreign key (house_id) references household(id),
foreign key (people_id) references people(id)
);

insert into household values
('HK-001','Van A','2022-02-01','Da Nang'),
('HK-002','Van B', '2022-12-11','Vinh'),
('HK-221','Van C', '2021-05-11','Da Nang'),
('HK-128','Van DA', '2021-05-11','Hue'),
('HK-111','Van AW', '2021-05-11','Vinh'),
('HK-241','Van AW', '2021-05-11','Da Nang');

insert into people(cmnd,`name`,birthday) values
('1111111','Thi A','2022-02-01'),employee
('1112111','Thi B','2022-02-01'),
('1111411','Thi C','2022-02-01'),
('1124511','Thi D','2022-02-01'),
('1141312', 'Van A', '2022-11-11'),
 ('4131313', 'Van B', '2022-11-21');

insert into people_live_house values 
('HK-001',1),
('HK-001',2),
('HK-111',3),
('HK-221',4);

USE `test_household`;
DROP function IF EXISTS `countPeopleInHouse`;

DELIMITER $$
USE `test_household`$$
CREATE FUNCTION `countPeopleInHouse` (id_check varchar(40))
RETURNS INTEGER deterministic
BEGIN
declare total int;
select count(*) into total from people_live_house where house_id = id_check;
RETURN total;
END$$

DELIMITER ;
