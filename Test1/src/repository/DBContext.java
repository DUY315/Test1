/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DBContext {
     static String url = "jdbc:sqlserver://localhost\\LAPTOP-ANOLV8QE\\SQLEXPRESS:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041";
    static String user = "sa";
    static String pass = "31052003";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            //Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Connection getConnect() {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
            //Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        // check thử
        Connection con = getConnect();
        if (con.equals("")) {
            System.out.println("loi ket noi");
        } else {
            System.out.println("ket noi thanh cong");
        }

    }
}
