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
public class LoSP {
    private int maLo,maPN,soLuong,maSP,soKho;
    private float tienNhap;
    private String trangThai,nguoiNhap,tenSP,tenNCC,Hinh,loaiSP;
    private Date ngaySX,HSD,NgayNhap;

    public LoSP() {
    }



    public LoSP( int maPN, int soLuong, int maSP, float tienNhap,  Date ngaySX, Date HSD, Date NgayNhap,int soKho,String tenSP,String tenNCC,String Hinh,String LoaiSP) {
        
        this.maPN = maPN;
        this.soLuong = soLuong;
        this.maSP = maSP;
        this.tienNhap = tienNhap;
        this.ngaySX = ngaySX;
        this.HSD = HSD;
        this.NgayNhap = NgayNhap;
        this.soKho=soKho;
        this.tenSP=tenSP;
        this.tenNCC=tenNCC;
        this.Hinh=Hinh;
        this.loaiSP=LoaiSP;
    }

    public LoSP(int maLo, String trangThai, String nguoiNhap, Date NgayNhap) {
        this.maLo = maLo;
        this.trangThai = trangThai;
        this.nguoiNhap = nguoiNhap;
        this.NgayNhap = NgayNhap;
    }

    public LoSP(int maLo, int soLuong, float tienNhap, Date ngaySX, Date HSD) {
        this.maLo = maLo;
        this.soLuong = soLuong;
        this.tienNhap = tienNhap;
        this.ngaySX = ngaySX;
        this.HSD = HSD;
    }

   


    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public int getMaLo() {
        return maLo;
    }

    public void setMaLo(int maLo) {
        this.maLo = maLo;
    }

    public int getMaPN() {
        return maPN;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }

    public Date getHSD() {
        return HSD;
    }

    public void setHSD(Date HSD) {
        this.HSD = HSD;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public float getTienNhap() {
        return tienNhap;
    }

    public void setTienNhap(float tienNhap) {
        this.tienNhap = tienNhap;
    }

    public int getSoKho() {
        return soKho;
    }

    public void setSoKho(int soKho) {
        this.soKho = soKho;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    @Override
    public String toString() {
        return maLo+"";
    }
    
    
}
