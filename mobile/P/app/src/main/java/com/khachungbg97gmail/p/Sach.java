package com.khachungbg97gmail.p;

/**
 * Created by ASUS on 11/22/2017.
 */

public class Sach {
    private int SachID;
    private int LoaiSachID;
    private int NgonNguID;
    private String NhaXB;
    private String TenSach;
    private String TacGia;
    private String NgayNhap;
    private String GiaTien;
    private int SoLuong;
    private int SoLuongCon;

    public Sach(int SachID,int LoaiSachID,int NgonNguID,String NhaXB,String TenSach,
                String TacGia,String NgayNhap,String GiaTien,int SoLuong,int SoLuongCon){
        this.SachID=SachID;
        this.LoaiSachID=LoaiSachID;
        this.NgonNguID=NgonNguID;
        this.NhaXB=NhaXB;
        this.TenSach=TenSach;
        this.TacGia=TacGia;
        this.NgayNhap=NgayNhap;
        this.GiaTien=GiaTien;
        this.SoLuong=SoLuong;
        this.SoLuongCon=SoLuongCon;

    }

    public int getSachID() {
        return SachID;
    }

    public void setSachID(int sachID) {
        SachID = sachID;
    }

    public int getLoaiSachID() {
        return LoaiSachID;
    }

    public void setLoaiSachID(int loaiSachID) {
        LoaiSachID = loaiSachID;
    }

    public int getNgonNguID() {
        return NgonNguID;
    }

    public void setNgonNguID(int ngonNguID) {
        NgonNguID = ngonNguID;
    }

    public String getNhaXB() {
        return NhaXB;
    }

    public void setNhaXB(String nhaXB) {
        NhaXB = nhaXB;
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

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        NgayNhap = ngayNhap;
    }

    public String getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(String giaTien) {
        GiaTien = giaTien;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getSoLuongCon() {
        return SoLuongCon;
    }

    public void setSoLuongCon(int soLuongCon) {
        SoLuongCon = soLuongCon;
    }
}

