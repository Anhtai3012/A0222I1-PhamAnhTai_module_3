use manager_student;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất
select*from `subject`
group by Credit
having max(Credit) >= all(select max(Credit) from `subject`group by Credit);
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
 
select su.SubName,max(m.Mark),s.StudentName from student s
join mark m on s.StudentId=m.StudentId
join `subject` su on su.SubId=m.SubId;
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
