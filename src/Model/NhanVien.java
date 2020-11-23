/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author hoang
 */
public class NhanVien {
    private String manv,hoten,sodienthoai,CMND,matkhau;
    private Date NgaySinh ;
    private boolean vaitro,gioitinh;

    public NhanVien(String manv, String hoten, String sodienthoai, String CMND, String matkhau, Date NgaySinh, boolean vaitro, boolean gioitinh) {
        this.manv = manv;
        this.hoten = hoten;
        this.sodienthoai = sodienthoai;
        this.CMND = CMND;
        this.matkhau = matkhau;
        this.NgaySinh = NgaySinh;
        this.vaitro = vaitro;
        this.gioitinh = gioitinh;
    }

    public NhanVien(String manv, String hoten, String sodienthoai, String CMND, Date NgaySinh, boolean gioitinh) {
        this.manv = manv;
        this.hoten = hoten;
        this.sodienthoai = sodienthoai;
        this.CMND = CMND;
        this.NgaySinh = NgaySinh;
        this.gioitinh = gioitinh;
    }
    

    public NhanVien() {
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isVaitro() {
        return vaitro;
    }

    public void setVaitro(boolean vaitro) {
        this.vaitro = vaitro;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }
    
    
   
    
}
