create database demo_baitap_ss5;
use demo_baitap_ss5;
create table product(
	id int primary key not null auto_increment,
code varchar(50),
name varchar(50),
price double,
amount int,
description varchar(100),
status tinyint
); 
-- 2
insert into product (code,name,price,amount,description,status) values
('code1','name1',1,1,'description1',0),
('code2','name2',2,2,'description1',0),
('code3','name3',3,3,'description1',0),
('code4','name4',4,4,'description1',0),
('code5','name5',5,5,'description1',0),
('code6','name6',6,6,'description1',0),
('code7','name7',7,7,'description1',0),
('code8','name8',8,8,'description1',0);
-- 3
EXPLAIN SELECT * from product p WHERE p.code= 'code1';
CREATE INDEX pro_quoc on product(`code`);
ALTER TABLE product add INDEX idx_code(`code`);

explain select * from product where name='name1' and price=1;
CREATE index abc on product(`name`, price);
ALTER TABLE product add INDEX composite_idx_name_price(`name`, price);
-- 4
CREATE view test_view as
SELECT `code`, `name`, price FROM product;
SELECT * from test_view;

update test_view set `name`= 'nokia' WHERE `code`= 'code2';
rename table test_view to product_view;
drop view product_view;
-- 5
DELIMITER //
CREATE PROCEDURE getAll()
BEGIN
	SELECT * from product;
END // DELIMITER ;

call getAll();


DELIMITER //
CREATE PROCEDURE add_product(pcode VARCHAR(50), pname VARCHAR(50), pprice DOUBLE)
BEGIN
INSERT INTO product (`code`, `name`, price) VALUE(pcode, pname, pprice);
END // DELIMITER ;

CALL add_product('AP', 'apple', 123);

DELIMITER //
create procedure update_product_by_id(pid int,pcode varchar(50),pname varchar(50),pprice double, pamount int, pdescription varchar(100), pstatus tinyint)
begin
update product
set name=pname,code=pcode,price=pprice,amount=pamount,description=pdescription,status=pstatus
where id=pid;
end
// DELIMITER ;

call update_product_by_id(1,'editcode','editname',9,9,'editdescription',1);


DELIMITER //
CREATE PROCEDURE delete_product_id(pid int)
BEGIN
DELETE FROM product WHERE id= pid;
END
// DELIMITER ;

CALL delete_product_id(1);