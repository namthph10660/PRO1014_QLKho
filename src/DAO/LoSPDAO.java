/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.LoSP;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TRAN NAM
 */
public class LoSPDAO {

    private static LoSPDAO instance;

    public static LoSPDAO getInstance() {
        if (instance == null) {
            instance = new LoSPDAO();
        }
        return instance;
    }

    public LoSPDAO() {
    }

    public ArrayList<LoSP> getListLoSP(Connection cn) {
        ArrayList<LoSP> result = new ArrayList<>();
        String sql = "Select MaLo,TrangThai,Hoten,ThoiGianNhap  from PHIEUNHAP inner join LOSANPHAM on LOSANPHAM.MaPhieuNhap=PHIEUNHAP.MaPhieuNhap inner join NHANVIEN on NHANVIEN.MaNhanVien=PHIEUNHAP.MaNhanVien";

        try {
            Statement sta = cn.createStatement();

            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                result.add(new LoSP(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4)
                ));
            }

            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }

    public ArrayList<LoSP> FindListLoSP(String ValToSearch, Connection cn) {
        ArrayList<LoSP> ListLoSP = new ArrayList<>();

        String sql = "Select MaLo,TrangThai,Hoten,ThoiGianNhap  from PHIEUNHAP inner join LOSANPHAM on LOSANPHAM.MaPhieuNhap=PHIEUNHAP.MaPhieuNhap\n"
                + "								inner join NHANVIEN on NHANVIEN.MaNhanVien=PHIEUNHAP.MaNhanVien\n"
                + "								where CONCAT(MaLo,ThoiGianNhap,Hoten,TrangThai) like N'%" + ValToSearch + "%'";
        try {
            PreparedStatement prs = cn.prepareStatement(sql);

            ResultSet rs = prs.executeQuery();
            LoSP loSP;

            while (rs.next()) {
                loSP = new LoSP(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4)
                );
                ListLoSP.add(loSP);
            }
            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return ListLoSP;
    }

    public ArrayList<LoSP> get20NguonCungCap(ArrayList<LoSP> arr, long Trang) {
        ArrayList<LoSP> result = new ArrayList<>();
        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }

    public LoSP ChiTietLo(int maLo, Connection cn) {
        LoSP sp = new LoSP();
        String sql = "select LoSanPham.MaPhieuNhap,LOSANPHAM.SoLuong ,LOSANPHAM.MaSP,GiaNhap,NgaySX,HanSuDung,ThoiGianNhap,SANPHAM.SoLuongSP,Tensp,TenNhaCC,Hinh,Tenloaisp from LOSANPHAM inner join PHIEUNHAP on LOSANPHAM.MaPhieuNhap=PHIEUNHAP.MaPhieuNhap \n"
                + "						inner join SANPHAM on LOSANPHAM.MaSP=SANPHAM.MaSP\n"
                + "						inner join NHACUNGCAP on NHACUNGCAP.MaNhaCC=PHIEUNHAP.manhacc\n"
                + "                                             inner join LoaiSP on SANPHAM.MaloaiSP=LoaiSP.MaloaiSP"
                + "						where MaLo=?";
        try {
            PreparedStatement prs = cn.prepareStatement(sql);
            prs.setInt(1, maLo);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                sp.setMaPN(rs.getInt(1));
                sp.setSoLuong(rs.getInt(2));
                sp.setMaSP(rs.getInt(3));
                sp.setTienNhap(rs.getFloat(4));
                sp.setNgaySX(rs.getDate(5));
                sp.setHSD(rs.getDate(6));
                sp.setNgayNhap(rs.getDate(7));
                sp.setSoLuong(rs.getInt(8));
                sp.setTenSP(rs.getString(9));
                sp.setTenNCC(rs.getString(10));
                sp.setHinh(rs.getString(11));
                sp.setLoaiSP(rs.getString(12));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return sp;
    }

    public boolean UpdateLoSP(int MaLo,
            int SoLuong,
            Connection cn) {

        try {
            String sql = "UPDATE LOSANPHAM SET SoLuong=SoLuong + ? where MaLo=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, SoLuong);
            ps.setInt(2, MaLo);

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
}
