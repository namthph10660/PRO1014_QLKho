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
public class Thuoctinh {
    public String matt,maloaisp,truongtt,dvt;

    public Thuoctinh(String matt, String maloaisp, String truongtt, String dvt) {
        this.matt = matt;
        this.maloaisp = maloaisp;
        this.truongtt = truongtt;
        this.dvt = dvt;
    }

    public Thuoctinh() {
    }

    public String getMatt() {
        return matt;
    }

    public void setMatt(String matt) {
        this.matt = matt;
    }

    public String getMaloaisp() {
        return maloaisp;
    }

    public void setMaloaisp(String maloaisp) {
        this.maloaisp = maloaisp;
    }

    public String getTruongtt() {
        return truongtt;
    }

    public void setTruongtt(String truongtt) {
        this.truongtt = truongtt;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }
    
    
}
