/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ChiTietPX;
import Model.LoSP;
import Model.PhieuXuat;
import Model.SanPham;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TRAN NAM
 */
public class PhieuXuatDAO {

    private static PhieuXuatDAO instance;

    public static PhieuXuatDAO getInstance() {
        if (instance == null) {
            instance = new PhieuXuatDAO();
        }
        return instance;
    }

    public PhieuXuatDAO() {
    }

    public ArrayList<ChiTietPX> getListPhieuXuat(Connection cn, int mapx) {
        ArrayList<ChiTietPX> result = new ArrayList<>();
        String sql = "select * from CTPHIEUXUAT where MaPhieuXuat=?";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, mapx);
            ResultSet rs = ps.executeQuery();
            ChiTietPX CT;

            while (rs.next()) {
                CT = new ChiTietPX(
                        rs.getInt(1),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(2),
                        rs.getFloat(3)
                );
                result.add(CT);
            }
            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }

    public boolean insertPhieuXuat(PhieuXuat px,
            Connection cn) {
        String sql = "INSERT INTO PhieuXuat VALUES(?,?,?,?)";
        try {

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, px.getNgayXuat());
            ps.setFloat(2, px.getGiaXuat());
            ps.setFloat(3, px.getTongTien());
            ps.setString(4, px.getMaNV());

            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return true;
    }

    public boolean insertPhieuXuatCT(ChiTietPX ctpx,
            Connection cn) {
        String sql = "INSERT INTO CTPHIEUXUAT VALUES(?,?,?,?)";
        try {

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, ctpx.getSoLuong());
            ps.setFloat(2, ctpx.getThanhTien());
            ps.setInt(3, ctpx.getMaLo());
            ps.setInt(4, ctpx.getMaPX());

            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return true;
    }

    public boolean UpdatePhieuXuat(int MaPX,
            String TGXuat,
            Float GiaXuat,
            Float TongTien,
            Connection cn) {

        try {
            String sql = "UPDATE PhieuXuat SET ThoiGianXuat=?,GiaXuat=?,TongTien=? where MaPhieuXuat=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, TGXuat);
            ps.setFloat(2, GiaXuat);
            ps.setFloat(3, TongTien);
            ps.setInt(4, MaPX);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Thành công!",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return false;
    }

    public boolean deleteCT(int maCT, Connection cn) {
        String sql = "DELETE FROM ChiTietPhieuXuat WHERE MaCTPhieuXuat=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, maCT);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Xóa thành công",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return false;
    }

    public boolean UpdateSP(int MaSP,
            int SoLuong,
            Connection cn) {

        try {
            String sql = "UPDATE SANPHAM SET SoLuongSP=SoLuongSP + ? where MaSP=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, MaSP);
            ps.setInt(2, SoLuong);

            ps.executeUpdate();

//            JOptionPane.showMessageDialog(null,
//                    "Thành công!",
//                    "Thông báo",
//                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return false;
    }
    
    public ArrayList<SanPham> fillCBSP(Connection cn){
        
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            String sql="select MaSP, TenLoaiSP,TenSP from SanPham inner join LoaiSP on LoaiSP.MaloaiSP=SANPHAM.MaloaiSP";
            PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            list.clear();
            while(rs.next()){
                 SanPham a =new SanPham(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
   
        return list;
    }
   
    
    public ArrayList<LoSP> fillCBLoSP(int maSP,Connection cn){
        ArrayList<LoSP> list = new ArrayList<>();
        try {
            String sql="select MaLo,LOSANPHAM.SoLuong,GiaNhap,NgaySX,HanSuDung from LOSANPHAM inner join PHIEUNHAP on PHIEUNHAP.MaPhieuNhap=LOSANPHAM.MaPhieuNhap where MaSP =? and LoSanPham.SoLuong>0 and TrangThai != N'Hàng lỗi'";
            
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, maSP);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 float a=Float.parseFloat(rs.getString(3));
                 
                 LoSP sp = new LoSP(rs.getInt(1),rs.getInt(2),a,rs.getDate(4),rs.getDate(5));
                 
                 list.add(sp);
             }
             rs.close();
        } catch (Exception e) {
        }
        return list;
    }
    
    
}
