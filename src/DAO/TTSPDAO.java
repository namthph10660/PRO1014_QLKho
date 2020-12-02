/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ThuocTinhSP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TRAN NAM
 */
public class TTSPDAO {
    private static TTSPDAO instance;

    public static TTSPDAO getInstance() {
        if (instance == null) {
            instance = new TTSPDAO();
        }
        return instance;
    }

    public TTSPDAO() {
    }

    public ArrayList<ThuocTinhSP> getListTT(Connection cn, int maSP) {
        ArrayList<ThuocTinhSP> result = new ArrayList<>();
        String sql = "select TruongTT,DonViTinh,GiaTri from THUOCTINH inner join TTSP on TTSP.MaThuocTinh=THUOCTINH.MaThuocTinh\n"
                + "						where MaSP=? ";
        try {
            PreparedStatement prs = cn.prepareStatement(sql);
            prs.setInt(1, maSP);
            ResultSet rs = prs.executeQuery();
            while(rs.next()){
                result.add(new ThuocTinhSP(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                       
                ));
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return result;
    }
}
