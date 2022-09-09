create database if not exists ss12_jdbc_crud;
use ss12_jdbc_crud;
CREATE TABLE user_ss12 (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name_user VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    country VARCHAR(50)
);
 
insert into user_ss12(name_user, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into user_ss12(name_user, email, country) values('Kante','kante@che.uk','Kenia');
 drop table user_ss12;