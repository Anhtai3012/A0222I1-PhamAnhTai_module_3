create database p2_ss13;
use p2_ss13;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

create table Permision(
id int primary key,
`name` varchar(50)
);

create table User_Permision(

permision_id int(11),

user_id int(11),
foreign key(user_id) references users(id),
foreign key(permision_id) references Permision(id)
);

insert into Permision(id, `name`) values(1,'add');

insert into Permision(id, `name`) values(2, 'edit');

insert into Permision(id, `name`) values(3, 'delete');

insert into Permision(id, `name`) values(4, 'view');
insert into users(`name`, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('Kante','kante@che.uk','Kenia');