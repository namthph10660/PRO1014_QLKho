/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author TRAN NAM
 */
public class NhaCungCap {
    private String MaNhaCC,TenNhaCC,NguoiDD,Email,SDT,DiaChi;

    public NhaCungCap() {
    }

    public NhaCungCap(String MaNhaCC, String TenNhaCC, String NguoiDD, String Email, String SDT, String DiaChi) {
        this.MaNhaCC = MaNhaCC;
        this.TenNhaCC = TenNhaCC;
        this.NguoiDD = NguoiDD;
        this.Email = Email;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
    }

    public String getMaNhaCC() {
        return MaNhaCC;
    }

    public void setMaNhaCC(String MaNhaCC) {
        this.MaNhaCC = MaNhaCC;
    }

    public String getTenNhaCC() {
        return TenNhaCC;
    }

    public void setTenNhaCC(String TenNhaCC) {
        this.TenNhaCC = TenNhaCC;
    }

    public String getNguoiDD() {
        return NguoiDD;
    }

    public void setNguoiDD(String NguoiDD) {
        this.NguoiDD = NguoiDD;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
}
