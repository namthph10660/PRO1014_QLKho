/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hoang
 */
public class LoaiSanPham {
   private String maloaisp,TenLoaiSP,DonViTinh,MaTT,TruongTT,Dvt;

    public LoaiSanPham() {
    }

    public LoaiSanPham(String maloaisp, String TenLoaiSP, String DonViTinh, String MaTT, String TruongTT, String Dvt) {
        this.maloaisp = maloaisp;
        this.TenLoaiSP = TenLoaiSP;
        this.DonViTinh = DonViTinh;
        this.MaTT = MaTT;
        this.TruongTT = TruongTT;
        this.Dvt = Dvt;
    }

    public LoaiSanPham(String maloaisp, String TenLoaiSP, String DonViTinh) {
        this.maloaisp = maloaisp;
        this.TenLoaiSP = TenLoaiSP;
        this.DonViTinh = DonViTinh;
    }

    public LoaiSanPham(String maloaisp, String MaTT, String TruongTT, String Dvt) {
        this.maloaisp = maloaisp;
        this.MaTT = MaTT;
        this.TruongTT = TruongTT;
        this.Dvt = Dvt;
    }

    
    public String getMaloaisp() {
        return maloaisp;
    }

    public void setMaloaisp(String maloaisp) {
        this.maloaisp = maloaisp;
    }

    public String getTenLoaiSP() {
        return TenLoaiSP;
    }

    public void setTenLoaiSP(String TenLoaiSP) {
        this.TenLoaiSP = TenLoaiSP;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public String getMaTT() {
        return MaTT;
    }

    public void setMaTT(String MaTT) {
        this.MaTT = MaTT;
    }

    public String getTruongTT() {
        return TruongTT;
    }

    public void setTruongTT(String TruongTT) {
        this.TruongTT = TruongTT;
    }

    public String getDvt() {
        return Dvt;
    }

    public void setDvt(String Dvt) {
        this.Dvt = Dvt;
    }
   
   
    
}
