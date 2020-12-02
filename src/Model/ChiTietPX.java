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
public class ChiTietPX {
    private int maCTPX,maLo,MaPX;
    private int soLuong;
    private  float thanhTien;

    public ChiTietPX() {
    }

    public ChiTietPX(int maCTPX, int maLo, int MaPX, int soLuong, float thanhTien) {
        this.maCTPX = maCTPX;
        this.maLo = maLo;
        this.MaPX = MaPX;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public int getMaCTPX() {
        return maCTPX;
    }

    public void setMaCTPX(int maCTPX) {
        this.maCTPX = maCTPX;
    }

    public int getMaLo() {
        return maLo;
    }

    public void setMaLo(int maLo) {
        this.maLo = maLo;
    }

    public int getMaPX() {
        return MaPX;
    }

    public void setMaPX(int MaPX) {
        this.MaPX = MaPX;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    

    
    
}
