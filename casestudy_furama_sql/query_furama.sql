
use furama ;
-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là
-- một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select*from nhan_vien
where ho_ten regexp '[htk][a-z]+$';

-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và
-- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select*from khach_hang
where year(ngay_sinh) between 1972 and 2004 and(dia_chi regexp 'Đà Nẵng|Quảng Trị');

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
 select hd.ma_khach_hang,kh.ho_ten,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc
  from hop_dong hd
 join khach_hang kh on hd.ma_khach_hang= kh.ma_khach_hang
 join hop_dong_chi_tiet hdct on hdct.ma_hop_dong=hd.ma_hop_dong
 join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem
 join dich_vu dv on dv.ma_dich_vu=hd.ma_dich_vu;