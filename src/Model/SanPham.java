/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class SanPham {
    private String MaSp,LoaiSp,Tensp,Hinh;
    int SoLuong;

    public SanPham(String MaSp, String LoaiSp, String Tensp, String Hinh, int SoLuong) {
        this.MaSp = MaSp;
        this.LoaiSp = LoaiSp;
        this.Tensp = Tensp;
        this.Hinh = Hinh;
        this.SoLuong = SoLuong;
    }

    public SanPham(String MaSp, String LoaiSp, String Tensp) {
        this.MaSp = MaSp;
        this.LoaiSp = LoaiSp;
        this.Tensp = Tensp;
    }

    public SanPham() {
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public String getLoaiSp() {
        return LoaiSp;
    }

    public void setLoaiSp(String LoaiSp) {
        this.LoaiSp = LoaiSp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String Tensp) {
        this.Tensp = Tensp;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    @Override
    public String toString() {
        return Tensp+"";
    }
    

}
