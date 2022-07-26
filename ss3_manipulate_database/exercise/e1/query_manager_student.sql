use manager_student;
--
select * from Student  
where StudentName LIKE 'h%';
--
select*from Class
where month(StartDate)=12;
--
select*from `Subject`
where Credit between 3 and 5;
--
update Student 
set ClassId = 2 
where StudentName ='Hung';
--
select S.StudentName,Su.SubName,M.Mark from Student S
inner join Mark M on S.StudentId=M.StudentId
join `Subject` Su on M.SubId=Su.SubId
order by M.Mark desc;
--
select S.StudentName 'ten_hoc_sinh' from Student S;

