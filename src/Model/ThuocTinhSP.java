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
public class ThuocTinhSP {
    private int maTT,maGT,maSP;
    private String truongTT,DVT,giaTri,maLoai;

    public ThuocTinhSP() {
    }

    public ThuocTinhSP(int maTT, int maGT, int maSP, String truongTT, String DVT, String giaTri, String maLoai) {
        this.maTT = maTT;
        this.maGT = maGT;
        this.maSP = maSP;
        this.truongTT = truongTT;
        this.DVT = DVT;
        this.giaTri = giaTri;
        this.maLoai = maLoai;
    }

    public ThuocTinhSP(String truongTT, String DVT, String giaTri) {
        this.truongTT = truongTT;
        this.DVT = DVT;
        this.giaTri = giaTri;
    }

    public int getMaTT() {
        return maTT;
    }

    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }

    public int getMaGT() {
        return maGT;
    }

    public void setMaGT(int maGT) {
        this.maGT = maGT;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTruongTT() {
        return truongTT;
    }

    public void setTruongTT(String truongTT) {
        this.truongTT = truongTT;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public String getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(String giaTri) {
        this.giaTri = giaTri;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
    
}
