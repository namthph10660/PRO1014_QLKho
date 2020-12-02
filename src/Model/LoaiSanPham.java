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
    private String MaLoai,TenLoai,DonViTinh;

   

    public LoaiSanPham(String MaLoai, String TenLoai, String DonViTinh) {
        this.MaLoai = MaLoai;
        this.TenLoai = TenLoai;
        this.DonViTinh = DonViTinh;
    }

   
    public LoaiSanPham(String MaLoai, String TenLoai) {
        this.MaLoai = MaLoai;
        this.TenLoai = TenLoai;
    }
    
    public LoaiSanPham() {
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

   
    
}
