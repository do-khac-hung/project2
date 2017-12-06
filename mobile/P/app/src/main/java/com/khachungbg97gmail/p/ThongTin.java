package com.khachungbg97gmail.p;

/**
 * Created by ASUS on 12/5/2017.
 */

public class ThongTin {
    private String NgayQuaHan;
    private String TenSach;

    public String getNgayQuaHan() {
        return NgayQuaHan;
    }

    public ThongTin(String ngayQuaHan, String tenSach, String tacGia, String trangThai) {
        NgayQuaHan = ngayQuaHan;
        TenSach = tenSach;
        TacGia = tacGia;
        TrangThai = trangThai;
    }

    public void setNgayQuaHan(String ngayQuaHan) {
        NgayQuaHan = ngayQuaHan;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {
        TacGia = tacGia;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    private String TacGia;
    private String TrangThai;
}
