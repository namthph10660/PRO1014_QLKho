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
public class PhieuXuat {
    private int MaPX;
    private String ngayXuat,maNV;
    private float giaXuat;
    private float tongTien;

    public PhieuXuat() {
    }

    public PhieuXuat(int MaPX, String maNV, String ngayXuat, float giaXuat, float tongTien) {
        this.MaPX = MaPX;
        this.maNV = maNV;
        this.ngayXuat = ngayXuat;
        this.giaXuat = giaXuat;
        this.tongTien = tongTien;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    

    public int getMaPX() {
        return MaPX;
    }

    public void setMaPX(int MaPX) {
        this.MaPX = MaPX;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public float getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(float giaXuat) {
        this.giaXuat = giaXuat;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
    
}
