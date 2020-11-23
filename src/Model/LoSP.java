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
    private int maLo,maPN;
    private String trangThai,nguoiNhap;
    private Date ngaySX,HSD,NgayNhap;

    public LoSP() {
    }

    public LoSP(int maLo, String trangThai, String nguoiNhap, Date NgayNhap) {
        this.maLo = maLo;
        this.trangThai = trangThai;
        this.nguoiNhap = nguoiNhap;
        this.NgayNhap = NgayNhap;
    }

   
//    public LoSP(int maLo, int maPN, String trangThai, String nguoiNhap, Date ngaySX, Date HSD, Date NgayNhap) {
//        this.maLo = maLo;
//        this.maPN = maPN;
//        this.trangThai = trangThai;
//        this.nguoiNhap = nguoiNhap;
//        this.ngaySX = ngaySX;
//        this.HSD = HSD;
//        this.NgayNhap = NgayNhap;
//    }

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
    
    
}
