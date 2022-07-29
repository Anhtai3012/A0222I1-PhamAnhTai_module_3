 create database if not exists product_manager_1;
 use product_manager_1;
 create table customer(
	cID int primary key auto_increment,
    cName varchar(50),
    cAge int
 );
 create table `order` (
	oID int auto_increment primary key,
    cID int,
    oDate date,
    oTotaPrice double,
    foreign key (cID) references customer(cID)
 );
 create table product(
	pID int auto_increment primary key,
    pName varchar(50),
    pPrice double
 );
 create table orderDetail(
	oID int,
    pID int,
    OdQTY int,
    foreign key(oID) references `order`(oID),
    foreign key(pID) references product(pID)
 );