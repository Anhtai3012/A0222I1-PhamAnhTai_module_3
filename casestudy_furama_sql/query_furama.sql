use furama ;
-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là
-- một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select*from nhan_vien
where substring_index(ho_ten, ' ', -1)  regexp '^[htk]' and length(substring_index(ho_ten, ' ', -1))<=15;

-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và
-- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select*from khach_hang
where year(now())- year(ngay_sinh) between 18 and 50 and( dia_chi regexp 'Đà Nẵng|Quảng Trị');

-- 4 Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu
-- lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của
-- khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là
-- “Diamond”.
select kh.ho_ten,count(hd.ma_khach_hang) as count from khach_hang kh
join hop_dong hd on hd.ma_khach_hang=kh.ma_khach_hang
join loai_khach lk on lk.ma_loai_khach=kh.ma_loai_khach
where lk.ten_loai_khach='Diamond'
group by kh.ho_ten;
-- 5. Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong,
-- ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với
-- tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng *
-- Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem,
-- hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những
-- khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).


select ho_ten, ifnull(sum(so_luong * gia) + tmp.tong_chi_phi_thue, 0) as tong_tien  from khach_hang kh
left join hop_dong hd using (ma_khach_hang)
left join hop_dong_chi_tiet using (ma_hop_dong)
left join dich_vu_di_kem using (ma_dich_vu_di_kem)
left join 
(
select ma_khach_hang, sum(chi_phi_thue) as tong_chi_phi_thue from khach_hang kh1 join hop_dong using (ma_khach_hang) join dich_vu using (ma_dich_vu) group by hop_dong.ma_khach_hang
) tmp using (ma_khach_hang)
group by hd.ma_khach_hang;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select ma_dich_vu,ten_dich_vu,dien_tich,chi_phi_thue, ldv.ten_loai_dich_vu from dich_vu
join loai_dich_vu ldv using (ma_loai_dich_vu)
where not exists(select ngay_lam_hop_dong from hop_dong
-- join hop_dong using (ma_dich_vu) 
where hop_dong.ma_dich_vu=dich_vu.ma_dich_vu and ngay_lam_hop_dong between '2021-01-01' and '2021-03-31'
 );
 -- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select ma_dich_vu,ten_dich_vu,dien_tich,so_nguoi_toi_da,chi_phi_thue, ldv.ten_loai_dich_vu from dich_vu
join loai_dich_vu ldv using (ma_loai_dich_vu)
where exists(
 select*from hop_dong 
where dich_vu.ma_dich_vu=hop_dong.ma_dich_vu and year(ngay_lam_hop_dong) = 2020 
and not exists(select*from hop_dong 
where dich_vu.ma_dich_vu=hop_dong.ma_dich_vu and year(ngay_lam_hop_dong)=2021));
-- 8
select ho_ten from khach_hang
group by ho_ten
order by ho_ten;
-- 9
SELECT MONTH(ngay_lam_hop_dong) AS thang, COUNT(ma_khach_hang)
FROM hop_dong
WHERE
    YEAR(ngay_lam_hop_dong) = 2021
GROUP BY thang
ORDER BY thang;
-- 10
SELECT 
    ma_hop_dong,
    ngay_lam_hop_dong,
    ngay_ket_thuc,
    tien_dat_coc,
    ifnull((sum(so_luong)),0)
FROM hop_dong
        LEFT join hop_dong_chi_tiet hdct using(ma_hop_dong) 
        LEFT join dich_vu_di_kem using(ma_dich_vu_di_kem) 
GROUP BY hop_dong.ma_hop_dong
ORDER BY hop_dong.ma_hop_dong;
-- 11
SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,ten_dich_vu_di_kem
FROM dich_vu_di_kem
         join hop_dong_chi_tiet using(ma_dich_vu_di_kem)
         join hop_dong using(ma_hop_dong)
        join khach_hang using(ma_khach_hang)
         join loai_khach using(ma_loai_khach)
        where ten_loai_khach = 'Diamond'
        AND dia_chi REGEXP 'Vinh|Quảng Ngãi';
-- 12
SELECT 
    hop_dong.ma_hop_dong,
    nhan_vien.ho_ten AS ho_ten_nhan_vien,
    khach_hang.ho_ten AS ho_ten_khach_hang,
    khach_hang.so_dien_thoai,
    ten_dich_vu,
    tien_dat_coc,
    ifnull(sum(so_luong),0) as so_luong
FROM
    hop_dong
		left join hop_dong_chi_tiet using(ma_hop_dong)
        join khach_hang using(ma_khach_hang)
		 join  nhan_vien using(ma_nhan_vien)
		 join dich_vu using(ma_dich_vu)
       where  (MONTH(ngay_lam_hop_dong) BETWEEN 10 AND 12
        AND YEAR(ngay_lam_hop_dong) = 2020)
        AND ngay_lam_hop_dong NOT IN ((MONTH(ngay_lam_hop_dong) BETWEEN 1 AND 6)
        AND YEAR(ngay_lam_hop_dong) = 2021)
	group by ma_hop_dong;
-- 13 
select ten_dich_vu_di_kem,gia,sum(so_luong) as so_lan from dich_vu_di_kem 
join hop_dong_chi_tiet hdct using(ma_dich_vu_di_kem)
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan >= all(select sum(so_luong) from hop_dong_chi_tiet
	group by ma_dich_vu_di_kem
   -- order by sum(so_luong) 
);
-- 14
select ma_hop_dong,ten_loai_dich_vu,ten_dich_vu_di_kem,count(ma_dich_vu_di_kem) as so_lan
from 
	hop_dong_chi_tiet
    join dich_vu_di_kem using(ma_dich_vu_di_kem)
    join hop_dong using(ma_hop_dong)
    join dich_vu using(ma_dich_vu)
    join loai_dich_vu using(ma_loai_dich_vu)
    group by ma_dich_vu_di_kem
    having so_lan=1;
-- 15 
select ma_nhan_vien,ho_ten,ten_trinh_do,ten_bo_phan,so_dien_thoai,dia_chi
,count(ma_nhan_vien) from nhan_vien
join trinh_do using(ma_trinh_do)
join bo_phan using(ma_bo_phan)
join hop_dong hd using(ma_nhan_vien)
where (year(hd.ngay_lam_hop_dong) between 2020 and 2021)
group by ma_nhan_vien
having count(ma_nhan_vien) <=3 ;
-- 16 
DELETE FROM nhan_vien
WHERE NOT EXISTS (
		SELECT
			*
		FROM
			hop_dong
		WHERE
			nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
			AND YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN 2019 AND 2021);
-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.

update khach_hang 
set ma_loai_khach = 1
where ma_khach_hang in (
select t.ma_khach_hang from (

 select ma_khach_hang, ho_ten, ifnull(sum(so_luong * gia) + tmp.tong_chi_phi_thue, 0) tong_tien  from khach_hang kh
 left join loai_khach using (ma_loai_khach)
left join hop_dong hd using (ma_khach_hang)
left join hop_dong_chi_tiet using (ma_hop_dong)
left join dich_vu_di_kem using (ma_dich_vu_di_kem)
left join 
(
select ma_khach_hang, sum(chi_phi_thue) tong_chi_phi_thue from khach_hang kh1 join hop_dong using (ma_khach_hang) join dich_vu using (ma_dich_vu) group by hop_dong.ma_khach_hang
) tmp using (ma_khach_hang)
where year(ngay_lam_hop_dong) = 2021 and ten_loai_khach ='Platinium'
group by hd.ma_khach_hang
having tong_tien > 10000000

) t



);

 select ma_khach_hang, ho_ten, ifnull(sum(so_luong * gia) + tmp.tong_chi_phi_thue, 0) tong_tien   from khach_hang kh
 left join loai_khach using (ma_loai_khach)
left join hop_dong hd using (ma_khach_hang)
left join hop_dong_chi_tiet using (ma_hop_dong)
left join dich_vu_di_kem using (ma_dich_vu_di_kem)
left join 
(
select ma_khach_hang, sum(chi_phi_thue) tong_chi_phi_thue from khach_hang kh1 join hop_dong using (ma_khach_hang) join dich_vu using (ma_dich_vu) group by hop_dong.ma_khach_hang
) tmp using (ma_khach_hang)
where year(ngay_lam_hop_dong) = 2021 and ten_loai_khach = 'Platinium'
group by hd.ma_khach_hang
having tong_tien > 10000000;
-- 18 
delete from khach_hang 
where ho_ten in (
select tmp.ho_ten from
(select ho_ten from khach_hang 
  join hop_dong using(ma_khach_hang)
where year(ngay_lam_hop_dong) < 2021) tmp
);


;
-- 19 
update dich_vu_di_kem 
set gia= gia*2
where ma_dich_vu_di_kem in (
select tmp.ma_dich_vu_di_kem from (
select 
hdct.ma_dich_vu_di_kem,sum(so_luong) as so_luong 
	from hop_dong_chi_tiet hdct
join dich_vu_di_kem using(ma_dich_vu_di_kem)
join hop_dong using(ma_hop_dong)
where year(ngay_lam_hop_dong) = 2020
group by hdct.ma_dich_vu_di_kem
having so_luong > 10)tmp
 );
-- 20
select ma_nhan_vien,ho_ten from nhan_vien
union 
select ma_khach_hang,ho_ten from khach_hang;
-- 21 
create view v_nhan_vien as select *,count(ngay_lam_hop_dong) from nhan_vien
join hop_dong using(ma_nhan_vien)
where dia_chi regexp 'Hải Châu' and ngay_lam_hop_dong='2019-12-12'
group by ngay_lam_hop_dong 
having count(ngay_lam_hop_dong) >=1 ;
select*from v_nhan_vien;
-- 22
