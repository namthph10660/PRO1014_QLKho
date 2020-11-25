/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.NhanVien;
import java.sql.Connection;
import java.sql.Date;
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
     private static NhanVienDAO instance;

    public static NhanVienDAO getInstance() {
        if (instance == null) {
            instance = new NhanVienDAO();
        }
        return instance;
    }
    public NhanVienDAO(){}
    public ArrayList<NhanVien> getlistnhanvien (Connection cn){
        ArrayList<NhanVien> list= new ArrayList<>();
        
         try {
             String sql = "select * from NHANVIEN";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
             while (rs.next()) {
                String manv = rs.getString(1);
                String ten = rs.getString(2);
                String sodt = rs.getString(3);
                String CMND = rs.getString(4);
                Date NgaySinh = rs.getDate(5);
                boolean GioiTinh= rs.getBoolean(6);
                boolean vaitro= rs.getBoolean(7);
                String matkhau = rs.getString(8);
                list.add(new NhanVien(manv, ten, sodt, CMND, matkhau, NgaySinh, vaitro, GioiTinh));
             }
             rs.close();
            stm.close();
        } catch (Exception e) {
             throw new RuntimeException(e);
        }
         return list;
    }
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
