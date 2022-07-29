use manager_student;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from Student  
where StudentName LIKE 'h%';
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12
select*from Class
where month(StartDate)=12;
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5
select*from `Subject`
where Credit between 3 and 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update Student 
set ClassId = 2 
where StudentName ='Hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select S.StudentName,Su.SubName,M.Mark from Student S
inner join Mark M on S.StudentId=M.StudentId
join `Subject` Su on M.SubId=Su.SubId
order by M.Mark desc,Su.SubName asc;


