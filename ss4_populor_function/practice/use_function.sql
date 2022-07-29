
use manager_student;
--
select Address,count(StudentId) as'so luong hoc vien' from student
group by Address; 
--
select S.StudentId,S.StudentName,avg(Mark) from student S
join mark M ON M.StudentId=S.StudentId
group by S.StudentId,S.StudentName
having avg(Mark)>15;
--

SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL(SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);
