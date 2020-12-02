/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.NhaCungCap;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author TRAN NAM
 */
public class NhaCCDao {

    private static NhaCCDao instance;

    public static NhaCCDao getInstance() {
        if (instance == null) {
            instance = new NhaCCDao();
        }
        return instance;
    }

    public NhaCCDao() {
    }
    
    public ArrayList<NhaCungCap> getListNguonCungCap(Connection cn) {
        ArrayList<NhaCungCap> result = new ArrayList<>();
        String sql = "select * from NhaCungCap ";

        try {
            Statement sta = cn.createStatement();

            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                result.add(new NhaCungCap(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }

            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }

    public ArrayList<NhaCungCap> FindListNguonCungCap(String ValToSearch, Connection cn) {
        ArrayList<NhaCungCap> NhaCungCapList = new ArrayList<>();

        String sql = "SELECT * FROM NHACUNGCAP WHERE CONCAT(MaNhaCC, TenNhaCC,NguoiDaiDien,Email,SDT,DiaChi) LIKE '%" + ValToSearch + "%'";
        try {
            PreparedStatement prs = cn.prepareStatement(sql);

            ResultSet rs = prs.executeQuery();
            NhaCungCap NhaCC;

            while (rs.next()) {
                NhaCC = new NhaCungCap(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                NhaCungCapList.add(NhaCC);
            }
            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return NhaCungCapList;
    }

    //Thêm nguồn cung cấp mới
    public boolean insertNhaCungCap(String MaNCC,
            String TenNhaCC,
            String NguoiDD,
            String Email,
            String SDT,
            String DiaChi,
            Connection cn) {
        String sql = "INSERT INTO NhaCungCap VALUES(?,?,?,?,?,?)";
        try {

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, MaNCC);
            ps.setString(2, TenNhaCC);
            ps.setString(3, NguoiDD);
            ps.setString(4, Email);
            ps.setString(5, SDT);
            ps.setString(6, DiaChi);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,
                    "Thêm nhà cung cấp mới thành công.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return true;
    }

    //Lấy ra 1 nguồn cung cấp bằng id
    //Update thông tin nguồn cung cấp
    public boolean UpdateNhaCungCap(String MaNhaCC,
            String TenNhaCungCap,
            String TenDaiDien,
            String Email,
            String SDT,
            String DiaChi,
            Connection cn) {

        try {
            String sql = "UPDATE NhaCungCap SET TenNhaCC=?,NguoiDaiDien=?,Email=?,SDT=?,DiaChi=? where MaNhaCC=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, TenNhaCungCap);
            ps.setString(2, TenDaiDien);
            ps.setString(3, Email);
            ps.setString(4, SDT);
            ps.setString(5, DiaChi);
            ps.setString(6, MaNhaCC);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Sửa thông tin nhà cung cấp thành công",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return false;
    }

    public boolean XoaNhaCungCap(String MaNhaCC, Connection cn) {
        String sql = "DELETE FROM NhaCungCap WHERE MaNhaCC=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, MaNhaCC);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Xóa thông tin nhà cung cấp thành công",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return false;
    }

    public ArrayList<NhaCungCap> get20NguonCungCap(ArrayList<NhaCungCap> arr, long Trang) {
        ArrayList<NhaCungCap> result = new ArrayList<>();
        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
  
    public void ExcelNguonCungCap(ArrayList<NhaCungCap> arr) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("NhaCungCap");
        int rownum = 0;
        Cell cell;
        HSSFCellStyle style = createStyleForTitle(workbook);
        Row row;

        row = sheet.createRow(rownum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Tên nhà cung cấp");
        cell.setCellStyle(style);
        //
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên Đại Diện");
        cell.setCellStyle(style);
        //
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Email");
        cell.setCellStyle(style);
        //
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("SDT");
        cell.setCellStyle(style);
        //
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Địa chỉ");
        cell.setCellStyle(style);

        for (NhaCungCap ncc:arr) {
            rownum++;
            row = sheet.createRow(rownum);
            //
            row.createCell(0)  
            .setCellValue(ncc.getTenNhaCC());  
            //
            row.createCell(1)  
            .setCellValue(ncc.getNguoiDD());  
            //
            row.createCell(2)  
            .setCellValue(ncc.getEmail());  
            //
            row.createCell(3)  
            .setCellValue(ncc.getSDT());  
            //
            row.createCell(4)  
            .setCellValue(ncc.getDiaChi());  
            
        }
        File file = new File("F:/DuAn1/Excel/NhaCungCap.xls");
        
//        file.getParentFile().mkdirs();

        FileOutputStream outFile;
        try {
            outFile = new FileOutputStream(file);
            
            workbook.write(outFile);
            outFile.close(); 
            workbook.close();
            JOptionPane.showMessageDialog(null, "Tạo file Excel thành công ");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        System.out.println("Created file: " + file.getAbsolutePath());
        
    }

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    
    
 
}
