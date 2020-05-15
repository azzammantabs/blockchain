/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import static blockchain.nodeapi.stmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdullah Azzam
 */
public class tempnounceapi {
    
    static Statement stmt;
    static ResultSet rs;
    
    public void insertTempNounce(String nounce, Timestamp ts) {
        try {
        String sql = "INSERT INTO temp_nounce (nounce, timestamp) VALUES ('"+nounce+"','"+ts+"')";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(tempnounceapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            System.out.println("insert data into temp_nounce success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteTempNounce() {
        try {
        String sql = "DELETE FROM temp_nounce";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(tempnounceapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            System.out.println("delete temp_nounce success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public TempNounce getNounce1() {
        TempNounce tn = new TempNounce();
        try {
        String sql = "SELECT * FROM temp_nounce";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(tempnounceapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                if (rs.isFirst()) {
                    tn.setId(rs.getInt("id"));
                    tn.setNounce(rs.getString("nounce"));
                    tn.setTs(rs.getTimestamp("timestamp"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tn;
    }
    
    public boolean checkNounce1() {
        boolean st = false;
        try {
        String sql = "SELECT * FROM temp_nounce";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(tempnounceapi.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public TempNounce getNounce2() {
        TempNounce tn = new TempNounce();
        try {
        String sql = "SELECT * FROM temp_nounce";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connectnode2.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(tempnounceapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                if (rs.isFirst()) {
                    tn.setId(rs.getInt("id"));
                    tn.setNounce(rs.getString("nounce"));
                    tn.setTs(rs.getTimestamp("timestamp"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tn;
    }
    
    public boolean checkNounce2() {
        boolean st = false;
        try {
        String sql = "SELECT * FROM temp_nounce";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connectnode2.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(tempnounceapi.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public TempNounce getNounce3() {
        TempNounce tn = new TempNounce();
        try {
        String sql = "SELECT * FROM temp_nounce";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connectnode3.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(tempnounceapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                if (rs.isFirst()) {
                    tn.setId(rs.getInt("id"));
                    tn.setNounce(rs.getString("nounce"));
                    tn.setTs(rs.getTimestamp("timestamp"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tn;
    }
    
    public boolean checkNounce3() {
        boolean st = false;
        try {
        String sql = "SELECT * FROM temp_nounce";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connectnode3.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(tempnounceapi.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
}
