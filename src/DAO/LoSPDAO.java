/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.LoSP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
                + "								where CONCAT(MaLo,ThoiGianNhap,Hoten,TrangThai) like '%" + ValToSearch + "%'";
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
}
