create database codegym;
use codegym;
create table products (
id int,
productCode varchar(10),
productName  varchar(50),
productPrice int ,
productAmount int,
productDescription varchar(50),
productStatus char (10)
);

alter table products add unique index_productCode (productCode);

alter table products add index index_name_price (productName, productPrice);

