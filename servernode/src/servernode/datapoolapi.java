/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servernode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static servernode.nodeapi.stmt;

/**
 *
 * @author Abdullah Azzam
 */
public class datapoolapi {
    
    static Statement stmt;
    static ResultSet rs;
    
     
     public boolean checkDataPool() {
        boolean st = false;
        try {
        String sql = "SELECT * FROM data_pool";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(datapoolapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                st = true;
            } else {
                st = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return st;
    }
     
     public Block getDataPool() {
        Block lBlock = new Block();
        try {
        String sql = "SELECT * FROM data_pool";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(nodeapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                if (rs.isFirst()) {
                    lBlock.index = rs.getInt("id");
                    lBlock.data = rs.getString("data");
                    lBlock.timestamp = rs.getString("timestamp");
                    lBlock.prevHash = rs.getString("prevhash");
                    lBlock.hash = rs.getString("hash");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lBlock;
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
