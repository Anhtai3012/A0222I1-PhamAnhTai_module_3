create database if not exists relationship;

use relationship;
CREATE TABLE nha_lien_he (
    sdt VARCHAR(10) primary key,
    ten_nguoi_lien_he VARCHAR(50),
    address VARCHAR(50)
);

CREATE TABLE nha_cc (
    ma_ncc VARCHAR(10) primary key,
    ten_cc VARCHAR(50),
    dia_chi VARCHAR(50),
    sdt VARCHAR(10),
    FOREIGN KEY (sdt)
        REFERENCES nha_lien_he (sdt)
);

CREATE TABLE don_vi_dh (
    so_dh VARCHAR(10) PRIMARY KEY,
    ngaydh DATETIME,
    ma_ncc VARCHAR(10),
    CONSTRAINT fk_cc_dh FOREIGN KEY (ma_ncc)
        REFERENCES nha_cc (ma_ncc)
);

CREATE TABLE phieu_xuat (
    so_px VARCHAR(10) PRIMARY KEY,
    ngay_xuat DATETIME
);

CREATE TABLE phieu_nhap (
    so_pn VARCHAR(10) PRIMARY KEY,
    ngay_nhap DATETIME
);

CREATE TABLE vat_tu (
    ma_vtu VARCHAR(10) PRIMARY KEY,
    ten_vtu VARCHAR(50)
);

CREATE TABLE cu_the_xuat_vat_tu (
    so_px VARCHAR(10),
    ma_vtu VARCHAR(10),
    dg_xuat VARCHAR(10),
    sl_xuat INT,
    CONSTRAINT fk_xuat_vt FOREIGN KEY (so_px)
        REFERENCES phieu_xuat (so_px),
    CONSTRAINT fk_vt_xuat FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu)
);

CREATE TABLE cu_the_nhap_vat_tu (
    so_pn VARCHAR(50),
    ma_vtu VARCHAR(10),
    dg_nhap VARCHAR(10),
    sl_nhap INT,
    CONSTRAINT fk_nhap_vt FOREIGN KEY (so_pn)
        REFERENCES phieu_nhap (so_pn),
    CONSTRAINT fk_vt_nhap FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu)
);

CREATE TABLE cu_the_dieu_hanh_vat_tu (
    so_dh VARCHAR(10),
    ma_vtu VARCHAR(10),
    ngay_dh DATE,
    so_luong INT,
    CONSTRAINT fk_dh_vt FOREIGN KEY (so_dh)
        REFERENCES don_vi_dh (so_dh),
    CONSTRAINT fk_vt_dh FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu)
);
