SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL(SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);


select * from student;



use product_manager_1;
-- customer
insert into customer(cName,cAge)
values('Minh Quan',10),
('Ngoc Oanh',20),
('Hong Ha',50);
-- Order
insert into `order`(cID,oDate)
values(1,'2006-3-21'),
(2,'2006-3-23'),
(1,'2006-3-16');
-- product
insert into product(pName,pPrice)
values('May Giat',3),
('Tu Lanh',5),
('Dieu Hoa',7),
('Quat',1),
('Bep Dien',2);
-- orderdetail
insert into orderdetail(oID,pID,OdQTY) 
values (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
-- display oid,odate,oprice of order table
select*from `order` ;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select C.cName, P.pName,count(P.pName) from product P 
join orderdetail O on  O.pID = P.pID
join `order` ord on ord.oID=O.oID
join customer C on C.cID=ord.cID
group by C.cName, P.pName;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select cName from customer
where cID not in(select cID from `order`);

select * from customer c
left join `order` od on od.cID=c.cID
where od.cID is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select o.oID as'bill code',o.oDate as 'Sell date',(od.OdQTY*p.pPrice) as 'price' from `order` o
join orderdetail od on od.oID = o.oID
join product p on od.pID = p.pID;


