create database quan_li_sinh_vien;
use quan_li_sinh_vien;
create table Class(
 ClassID int not null auto_increment key,
 ClassName varchar(60) not null,
 StartDate datetime not null,
 Start bit 
);
create table Student(
	Student int not null auto_increment primary key,
    StudentName varchar(30) not null ,
    Adress varchar(50),
    Phone varchar(20),
    Start bit,
    ClassID int not null,
    Foreign key (ClassID) REFERENCES Class (ClassID)
);
create TABLE  Subject(
	Subid int not null auto_increment primary key ,
    SubName varchar(30) not null,
    Credit tinyint not null default 1 check (Credit >= 1),
    Start bit default 1
);
create table Mark(
	MarkID INT NOT null auto_increment primary KEY,
    SubID int not null,
    StudentID int not null,
    Mark float default 0 check (Mark between 0 and 100),
    ExamTime tinyint default 1,
    unique (SubID,StudentID),
    foreign key (SubID) references Subject (SubID),
    foreign key (StudentID) references Student (Student)
);