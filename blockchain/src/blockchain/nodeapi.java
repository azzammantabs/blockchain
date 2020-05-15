/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

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
public class nodeapi {
    
    static Statement stmt;
    static ResultSet rs;
    
    public void insertNode(int id, String data, String ts, String prevhash, String hash, String nounce) {
        try {
        String sql = "INSERT INTO node_block VALUES ('"+id+"','"+data+"','"+ts+"','"+prevhash+"','"+hash+"','"+nounce+"')";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(nodeapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            System.out.println("insert data into node_block computer 1 success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean checkNode() {
        boolean st = false;
        try {
        String sql = "SELECT * FROM node_block";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(nodeapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                st = false;
            } else {
                st = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return st;
    }
    
    public void insertAnisNode(int id, String data, String ts, String prevhash, String hash, String nounce) {
        try {
        String sql = "INSERT INTO node_block VALUES ('"+id+"','"+data+"','"+ts+"','"+prevhash+"','"+hash+"','"+nounce+"')";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connectnode2.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(nodeapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            System.out.println("insert data into node_block computer 2 success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean checkAnisNode() {
        boolean st = false;
        try {
        String sql = "SELECT * FROM node_block";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connectnode2.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(nodeapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                st = false;
            } else {
                st = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return st;
    }
    
    public void insertAbiNode(int id, String data, String ts, String prevhash, String hash, String nounce) {
        try {
        String sql = "INSERT INTO node_block VALUES ('"+id+"','"+data+"','"+ts+"','"+prevhash+"','"+hash+"','"+nounce+"')";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connectnode3.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(nodeapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            System.out.println("insert data into node_block computer 3 success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean checkAbiNode() {
        boolean st = false;
        try {
        String sql = "SELECT * FROM node_block";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connectnode3.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(nodeapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                st = false;
            } else {
                st = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return st;
    }
    
    public Block getLastBlockN() {
        Block lBlock = new Block();
        try {
        String sql = "SELECT * FROM node_block";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(nodeapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                if (rs.isLast()) {
                    lBlock.index = rs.getInt("id");
                    lBlock.data = rs.getString("data");
                    lBlock.timestamp = rs.getString("timestamp");
                    lBlock.prevHash = rs.getString("prevhash");
                    lBlock.hash = rs.getString("hash");
                    lBlock.nounce = rs.getString("nounce");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lBlock;
    }
    
    public void printNodeData() {
        try {
        String sql = "SELECT * FROM node_block";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connect.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(nodeapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println("id:         "+rs.getInt("id"));
                System.out.println("data:       "+rs.getString("data"));
                System.out.println("timestamp:  "+rs.getString("timestamp"));
                System.out.println("prevhash:   "+rs.getString("prevhash"));
                System.out.println("hash:       "+rs.getString("hash"));
                System.out.println("nounce:     "+rs.getString("nounce"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
