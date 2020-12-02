/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author TRAN NAM
 */
public class PhieuNhap {
    private int maPN,soLuong;
    private String ngayNhap;
    private float donGiaNhap,SoTien;
    private String maNCC,maNV,tenNV,tenSP;

    public PhieuNhap() {
    }

//    public PhieuNhap(int maPN, int soLuong, Date ngayNhap, float donGiaNhap, String maNCC, String maNV) {
//        this.maPN = maPN;
//        this.soLuong = soLuong;
//        this.ngayNhap = ngayNhap;
//        this.donGiaNhap = donGiaNhap;
//        this.maNCC = maNCC;
//        this.maNV = maNV;
//    }

    public PhieuNhap( String ngayNhap, String tenSP,int soLuong, float donGiaNhap, String tenNV,int maPN) {
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.donGiaNhap = donGiaNhap;
        this.tenNV = tenNV;
        this.tenSP = tenSP;
        this.maPN=maPN;
    }

    public float getSoTien() {
        return SoTien;
    }

    public void setSoTien(float SoTien) {
        this.SoTien = SoTien;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    

    
    
    public int getMaPN() {
        return maPN;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public float getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(float donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    

    
    
}
