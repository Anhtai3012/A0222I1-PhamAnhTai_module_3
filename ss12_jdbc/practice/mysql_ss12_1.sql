create database if not exists p1_ss12;
use p1_ss12;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(`name`, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('Kante','kante@che.uk','Kenia');

DELIMITER $$
create procedure get_user_by_id(in user_id int)
begin
select `name`,email,country 
from users
where user_id=id;
end $$
DELIMITER ;

call get_user_by_id(4);

DELIMITER //
create procedure insert_user(in user_name varchar(45),in user_email varchar(45),in user_country varchar(45))
begin
insert into users(`name`,email,country)
values(
user_name,user_email,user_country
);
end //
DELIMITER ;
call insert_user('anhtai','mkhanhaa2gmail.com','vietname');