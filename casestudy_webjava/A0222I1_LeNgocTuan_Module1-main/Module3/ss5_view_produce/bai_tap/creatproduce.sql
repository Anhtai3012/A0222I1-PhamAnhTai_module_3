USE codegym;
DROP procedure IF EXISTS `getallproducts`;

DELIMITER $$
USE codegym$$
CREATE PROCEDURE `getallproducts` ()
BEGIN
select * from products;
END$$

DELIMITER ;

USE codegym;
DROP procedure IF EXISTS `addProducts`;

DELIMITER $$
USE codegym$$
CREATE PROCEDURE `addProducts` (idvalue int, productCodevalue varchar(10),productNamevalue varchar(50),
productPricevalue int, productAmountvalue int,
 productDescriptionvalue varchar(50),productStatusvalue char(10))
BEGIN
insert into products(id,productCode,productName,productPrice,productAmount,productDescription,productStatus)
values (idvalue,productCodevalue,productNamevalue,productPricevalue,productAmountvalue,productDescriptionvalue,productStatusvalue);
END$$

DELIMITER ;

USE codegym;
DROP procedure IF EXISTS `editproducts`;

DELIMITER $$
USE codegym$$
CREATE PROCEDURE `editproducts` (productCodevalue varchar(10),productNamevalue varchar(50),
productPricevalue int, productAmountvalue int,
 productDescriptionvalue varchar(50),productStatusvalue char(10))
BEGIN
update products set productName = productNamevalue, productPrice =productPricevalue,productAmount = productAmountvalue,
productDescription =productDescriptionvalue, productStatus = productStatusvalue where productCode = productCodevalue;
END$$
DELIMITER ;

USE codegym;
DROP procedure IF EXISTS `deleteproducts`;

DELIMITER $$
USE codegym$$
CREATE PROCEDURE `deleteproducts` (productCodevalue varchar(10))
BEGIN
delete from products where productCode = productCodevalue;
END$$

DELIMITER ;
