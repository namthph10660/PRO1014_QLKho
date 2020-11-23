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
public class NhanVien {
    private String maNV,HoTen,SoDT,DiaChi,CMND;
    private boolean VaiTro;
    private Date NgaySinh;

    public NhanVien() {
    }

    public NhanVien(String maNV, String HoTen, String SoDT, String DiaChi, String CMND, boolean VaiTro, Date NgaySinh) {
        this.maNV = maNV;
        this.HoTen = HoTen;
        this.SoDT = SoDT;
        this.DiaChi = DiaChi;
        this.CMND = CMND;
        this.VaiTro = VaiTro;
        this.NgaySinh = NgaySinh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public boolean isVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    
}
