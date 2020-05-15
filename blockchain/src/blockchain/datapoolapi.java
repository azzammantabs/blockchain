/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdullah Azzam
 */
public class datapoolapi {
    
    public void insertDatapool(int idx, String data, String timestamp, String prevhash, String hash) {
        try {
        String sql = "INSERT INTO data_pool VALUES ('"+idx+"','"+data+"','"+timestamp+"','"+prevhash+"','"+hash+"')";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(datapoolapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            System.out.println("insert data into data pool 1 success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertDatapoolNode2(int idx, String data, String timestamp, String prevhash, String hash) {
        try {
        String sql = "INSERT INTO data_pool VALUES ('"+idx+"','"+data+"','"+timestamp+"','"+prevhash+"','"+hash+"')";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connectnode2.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(datapoolapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            System.out.println("insert data into data pool 2  success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void insertDatapoolNode3(int idx, String data, String timestamp, String prevhash, String hash) {
        try {
        String sql = "INSERT INTO data_pool VALUES ('"+idx+"','"+data+"','"+timestamp+"','"+prevhash+"','"+hash+"')";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connectnode3.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(datapoolapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            System.out.println("insert data into data pool 3 success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteDatapool(int idx) {
        try {
        String sql = "DELETE FROM data_pool WHERE id = '"+idx+"'";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(datapoolapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            System.out.println("delete data pool success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }     
}
