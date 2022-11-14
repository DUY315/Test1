/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.ChucVu;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;
import utilities.JDBC_Helper;

/**
 *
 * @author ADMIN
 */
public class ChucVuRepos {

    public static List<ChucVu> getAll() {
        List<ChucVu> listcv = new ArrayList<>();
        ResultSet rs;
        String sql = "select ma, ten from ChucVu";
        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                ChucVu cv = new ChucVu(ma, ten);
                listcv.add(cv);
            }
            return listcv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ChucVu getByM(String m) {
        ChucVu cv = null;
        ResultSet rs;
        String sql = "Select ma,ten from ChucVu where ma=? ";
        rs = JDBC_Helper.selectTongQuat(sql, m);
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);

                cv = new ChucVu(ma, ten);
            }
            return cv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int them(ChucVu cv) {
        
        String sql = "insert into ChucVu (ma,ten) values (?,?)";
        if (checkTrungMa(cv.getMa())) {
            JOptionPane.showMessageDialog(null , "Trung ma");
            return 0;
        }else{
             return JDBC_Helper.UpdateTongQuat(sql, cv.getMa(), cv.getTen());
        }
       
    }

    public static ChucVu getCVByMaCV(String maCV) {
        ChucVu cv = null;
        ResultSet rs;
        String sql = "Select ma,ten from ChucVu where ma=?";

        rs = JDBC_Helper.selectTongQuat(sql, maCV);
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                cv = new ChucVu(ma, ten);

            }
            return cv;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
            //Logger.getLogger(GiangVien_Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean checkTrungMa(String macv) {
       ChucVu cv = getCVByMaCV(macv);
        if (cv == null) {
            return false;
        } else {
            return true;
        }
    }


}
