create database if not exists ss2_erd;

use ss2_erd;

CREATE TABLE customer (
    c_id INT PRIMARY KEY,
    c_name VARCHAR(50),
    c_age INT
);

CREATE TABLE orders (
    o_id INT PRIMARY KEY,
    c_id INT,
    o_date DATETIME,
    o_total_price INT,
    CONSTRAINT fk_o_c FOREIGN KEY (c_id)
        REFERENCES customer (c_id)
);

CREATE TABLE produce (
    p_id INT PRIMARY KEY,
    p_name VARCHAR(50),
    p_price INT
);


CREATE TABLE orders_details (
    o_id INT,
    p_id INT,
    od_qty INT,
    CONSTRAINT fk_od_o FOREIGN KEY (o_id)
        REFERENCES orders (o_id),
    CONSTRAINT fk_od_p FOREIGN KEY (p_id)
        REFERENCES produce (p_id)
);

insert into customer values 
(1,"Minh Quan",21),
(2,"Ngoc Oanh",32),
(3,"Hong Ha",40);

insert into orders (o_id,c_id,o_date) values 
(1,1,"2006-03-21"),
(2,2,"2006-03-23"),
(3,1,"2006-03-16");

insert into produce values 
(1,"may giat",3),
(2,"tu lanh",5),
(3,"dieu hoa",7),
(4,"quat",1),
(5,"bep dien",2);

insert into orders_details values 
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- 1 --
SELECT 
    *
FROM
    orders;

-- 2 --
SELECT 
    c_name, p_name
FROM
    customer
        INNER JOIN
    orders ON orders.c_id = customer.c_id
        INNER JOIN
    orders_details ON orders_details.o_id = orders.o_id
        INNER JOIN
    produce ON produce.p_id = orders_details.p_id;

-- 3 -- 
SELECT 
    *
FROM
    customer
WHERE
    c_id NOT IN (SELECT 
            c_id
        FROM
            orders);

-- 4 -- 
SELECT 
    orders.o_id, o_date, (od_qty * p_price) o_total_price
FROM
    orders
        INNER JOIN
    orders_details ON orders_details.o_id = orders.o_id
        INNER JOIN
    produce ON orders_details.p_id = produce.p_id;