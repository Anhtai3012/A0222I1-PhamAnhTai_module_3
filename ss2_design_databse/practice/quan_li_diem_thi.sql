create database if not exists quan_li_diem_thi;
use quan_li_diem_thi;
create table hoc_sinh(
	MaHS varchar (20) primary KEY,
    TenHS varchar(50),
    NgaySinh datetime,
    Lop varchar(20),
    GT varchar(20)
);
create table MonHoc(
	MaMH VARCHAR(20) PRIMARY KEY,
    TenMH VARCHAR(50)
);
CREATE TABLE BangDiem(
	MaHS VARCHAR(20),
    MaMH varchar(20),
    DiemThi int,
    NgayKT DATETIME,
    fOREIGN KEY (MaHS) REFERENCES hoc_sinh(MaHS),
    FOREIGN KEY (MaMH) REFERENCES MonHoc(MaMH)
);
create table GiaoVien(
	 MaGV VARCHAR(20) PRIMARY KEY,
     TenGV VARCHAR(20),
     SDT VARCHAR(10)
);
ALTER TABLE MonHoc add MaGV varchar(20);
alter table Monhoc add constraint FK_MaGV foreign KEY (MaGV) references GiaoVien(MaGV);