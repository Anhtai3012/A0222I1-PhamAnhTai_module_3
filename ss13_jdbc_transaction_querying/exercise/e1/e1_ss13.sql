create database e1_ss13;
use e1_ss13;
create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
DELIMITER $$
create procedure display_user()
begin
select*from users;
end $$
DELIMITER ;
call display_user();
 DELIMITER $$ 
 create procedure edit_user(user_name varchar(45),user_email varchar(45), user_country varchar(45), user_id int)
 begin
 update users set `name` =user_name ,email= user_email, country =user_country where id = user_id;
 end $$
 DELIMITER ;
 
 call edit_user('','','','');
 
 DELIMITER $$
 create procedure delete_user(user_id int)
 begin
delete from users where id=user_id;
 end $$
 DELIMITER ;
 
 call delete_user(2);

select * from users where `name`='Tai';

