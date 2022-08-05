delete from khach_hang where ho_ten not in (select kh.ho_ten from khach_hang kh join hop_dong using(ma_khach_hang) where year(ngay_lam_hop_dong)<2021)
