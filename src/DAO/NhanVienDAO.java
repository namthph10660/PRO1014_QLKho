/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.NhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author TRAN NAM
 */
public class NhanVienDAO {
    Connection cn;
//    public ArrayList<NhanVien> getListTaiKhoan() {
//        ArrayList<NhanVien> result = new ArrayList<>();
//        String sql = "select *from NhanVien";
//        ArrayList<Object> arr = new ArrayList<>();
//        try {
//            Statement sta= cn.createStatement();
//            ResultSet rs= sta.executeQuery(sql);
//            while (rs.next()) {
//                        
//                        rs.getString("ten_tai_khoan"),
//                        rs.getString("mat_khau"),
//                        rs.getInt("id_exist"),
//                        rs.getInt("id_nv"),
//                        rs.getInt("loai")));
//            }
//
//            DataProvider.getIntance().close();
//        } catch (SQLException ex) {
//            DataProvider.getIntance().displayError(ex);
//        }
//
//        return result;
//    }

    //Kiểm tra khi đăng nhập
//    public boolean KiemTraDangNhap(String User, String Pass) {
//        ArrayList<Object> arr = new ArrayList<>();
//
//        String query = "SELECT * FROM `Tai_khoan` WHERE ten_tai_khoan='" + User + "' and mat_khau='" + Pass + "'";
//        try {
//            DataProvider.getIntance().open();
//            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
//            if (rs.next()) {
//                return true;
//            }
//
//            DataProvider.getIntance().close();
//        } catch (SQLException ex) {
//            DataProvider.getIntance().displayError(ex);
//        }
//        return false;
//    }
}
