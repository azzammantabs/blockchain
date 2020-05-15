/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdullah Azzam
 */
public class clientapi { 
    
    public void insertClient(String uname, String pswd) {
        try {
        String sql = "INSERT INTO client VALUES ('"+uname+"','"+pswd+"')";
        java.sql.Connection conn = null;
            try {
                conn = (Connection)connectnode3.connectDB();
            } catch (SQLException ex) {
                Logger.getLogger(clientapi.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            System.out.println("insert data client berhasil");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

