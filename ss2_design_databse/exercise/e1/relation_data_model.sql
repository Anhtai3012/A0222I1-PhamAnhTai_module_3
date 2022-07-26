create database if not exists building;
use building;
create table phieu_xuat(
	so_px int auto_increment primary key,
    ngay_xuat date
);
create table vat_tu(
	ma_vtu int auto_increment primary key,
    ten_vtu varchar(50)
);
create table chi_tiet_phieu_xuat(
	px_id int,
    vat_tu_id int,
    primary key(px_id,vat_tu_id),
    foreign key(px_id) references phieu_xuat(so_px),
    foreign key(vat_tu_id) references vat_tu(ma_vtu)
); 
 create table phieu_nhap(
	so_pn int auto_increment primary key,
    ngay_nhap date
 );
create table chi_tiet_phieu_nhap(
	vattu_id int,
    phieu_nhap_id int,
    primary key(vattu_id,phieu_nhap_id),
    foreign key(vattu_id) references vat_tu(ma_vtu),
    foreign key(phieu_nhap_id) references phieu_nhap(so_pn)
 );
  create table nha_cc(
	ma_ncc int auto_increment primary key,
    ten_ncc varchar(50),
    dia_chi varchar(50)
 );
  create table don_dh(
	so_dh int auto_increment primary key,
    ngay_dh date,
    nha_cc_id int,
    foreign key(nha_cc_id) references nha_cc(ma_ncc)
 );
 create table chi_tiet_dat_hang(
	vattu_id int,
    don_dh_id int,
    primary key(vattu_id,don_dh_id),
    foreign key(vattu_id) references vat_tu(ma_vtu),
    foreign key(don_dh_id) references don_dh(so_dh)
 );
 create table so_dien_thoai(
	id int,
    foreign key (id) references nha_cc(ma_ncc)
 );