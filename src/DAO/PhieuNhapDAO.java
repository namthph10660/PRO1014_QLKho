/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.PhieuNhap;
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
public class PhieuNhapDAO {

    private static PhieuNhapDAO instance;

    public static PhieuNhapDAO getInstance() {
        if (instance == null) {
            instance = new PhieuNhapDAO();
        }
        return instance;
    }

    public PhieuNhapDAO() {
    }

    public ArrayList<PhieuNhap> getListPhieuNhap(Connection cn) {
        ArrayList<PhieuNhap> result = new ArrayList<>();
        String sql = "select ThoiGianNhap,Tensp,phieunhap.SoLuong,GiaNhap,Hoten,PHIEUNHAP.MaPhieuNhap from PHIEUNHAP inner join LOSANPHAM on PHIEUNHAP.MaPhieuNhap=LOSANPHAM.MaPhieuNhap\n"
                + "										inner join SANPHAM on SANPHAM.MaSP=LOSANPHAM.MaSP\n"
                + "                                                                             inner join NHANVIEN on PHIEUNHAP.MaNhanVien=NHANVIEN.MaNhanVien"
                + "                                                                             group by ThoiGianNhap,Tensp,phieunhap.SoLuong,GiaNhap,Hoten,PHIEUNHAP.MaPhieuNhap";

        try {
            Statement sta = cn.createStatement();

            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                result.add(new PhieuNhap(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6)
                ));
            }

            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }

    public ArrayList<PhieuNhap> FindListPhieuNhap(String ValToSearch, Connection cn) {
        ArrayList<PhieuNhap> PhieuNhapList = new ArrayList<>();

        String sql = "select ThoiGianNhap,Tensp,phieunhap.SoLuong,GiaNhap,Hoten from PHIEUNHAP inner join LOSANPHAM on PHIEUNHAP.MaPhieuNhap=LOSANPHAM.MaPhieuNhap\n"
                + "																	inner join SANPHAM on SANPHAM.MaSP=LOSANPHAM.MaSP\n"
                + "																	inner join NHANVIEN on PHIEUNHAP.MaNhanVien=NHANVIEN.MaNhanVien\n"
                + "										WHERE CONCAT(ThoiGianNhap,Tensp,phieunhap.SoLuong,GiaNhap,Hoten) like N'%" + ValToSearch + "%'"
                + "                                                                             group by ThoiGianNhap,Tensp,phieunhap.SoLuong,GiaNhap,Hoten,PHIEUNHAP.MaPhieuNhap";
        try {
            PreparedStatement prs = cn.prepareStatement(sql);

            ResultSet rs = prs.executeQuery();
            PhieuNhap PN;

            while (rs.next()) {
                PN = new PhieuNhap(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
                PhieuNhapList.add(PN);
            }
            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return PhieuNhapList;
    }

    public boolean XoaPhieuNhap(int MaPN, Connection cn) {
        String sql = "DELETE FROM PhieuNhap WHERE MaPhieuNhap=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, MaPN);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Xóa thông tin nhà cung cấp thành công",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể xóa phiếu nhập !");

        }
        return false;
    }

    public ArrayList<PhieuNhap> get20PhieuNhap(ArrayList<PhieuNhap> arr, long Trang) {
        ArrayList<PhieuNhap> result = new ArrayList<>();
        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
}
