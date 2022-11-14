/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import repository.DBContext;

/**
 *
 * @author ADMIN
 */
public class JDBC_Helper {
    public static void close(Connection con, PreparedStatement pstm) {
        try {
            pstm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection con, PreparedStatement pstm, ResultSet rs) {
        try {
            rs.close();
            close(con, pstm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet selectTongQuat(String sql, Object... params) {
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection con = null;
        try {
            con = DBContext.getConnect();
            pstm = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i + 1, params[i]);
            }
            rs = pstm.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            close(con, pstm, rs);
            return null;
        }
    }

    public static int UpdateTongQuat(String sql, Object... params) {
        PreparedStatement pstm = null;
        Connection con = null;
        try {
            con = DBContext.getConnect();
            pstm = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i + 1, params[i]);
            }
            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        finally{
            close(con, pstm);
        }
    }
}
