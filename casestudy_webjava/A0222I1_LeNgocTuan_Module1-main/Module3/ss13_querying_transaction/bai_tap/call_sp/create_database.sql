create database ss12_jdbc_crud;

use ss12_jdbc_crud;

CREATE TABLE user_ss12 (
    id INT PRIMARY KEY,
    `name` VARCHAR(50),
    email VARCHAR(50),
    country VARCHAR(50)
);

CREATE TABLE permision (
    permision_id INT PRIMARY KEY,
    name_permision VARCHAR(50)
);

CREATE TABLE user_permision (
    permision_id INT,
    id INT,
    CONSTRAINT fk_us_pr FOREIGN KEY (id)
        REFERENCES user_ss12 (id),
    CONSTRAINT fk_up_pr FOREIGN KEY (permision_id)
        REFERENCES Permision (permision_id)
);

insert into permision values(1, 'add'),(2, 'edit'),(3, 'delete'),(4, 'view');

INSERT INTO user_ss12 VALUES 
('12', 'Minh', 'minh@codegym.com', 'vietnam'),
('13', 'Kante', 'kante@gmail.com', 'France'),
('14', 'chanathip', 'chanathip@thailand.com', 'thailand'),
('19', 'kien', 'kien@yahoo.com', 'vietnam'),
('20', 'Yen', 'yensao@gmail.com.vn', 'vietnam');

USE `ss12_jdbc_crud`;
DROP procedure IF EXISTS `call_delete_user`;

DELIMITER $$
USE `ss12_jdbc_crud`$$
CREATE PROCEDURE `call_delete_user` (in id_in int)
BEGIN
select * from user_ss12 where id = id_in;
END$$

DELIMITER ;
DROP procedure IF EXISTS `call_all_user`;

DELIMITER $$
USE `ss12_jdbc_crud`$$
CREATE PROCEDURE `call_all_user` ()
BEGIN
select * from user_ss12;
END$$

DELIMITER ;

DROP procedure IF EXISTS `search_user`;

DELIMITER $$
USE `ss12_jdbc_crud`$$
CREATE PROCEDURE `search_user` (in id_search int)
BEGIN
select * from user_ss12 where id = id_search;
END$$

DELIMITER ;

DROP procedure IF EXISTS `ss12_jdbc_crud`.`update_user`;
;

DELIMITER $$
USE `ss12_jdbc_crud`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_user`(id_select int, new_name varchar(50), new_email varchar(50), new_country varchar(50))
BEGIN
update user_ss12 set id=id_select,`name` = new_name,email=new_email,country=new_country where id= id_select;
END$$

DELIMITER ;
;

