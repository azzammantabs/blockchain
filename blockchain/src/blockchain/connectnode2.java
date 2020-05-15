/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdullah Azzam
 */
public class connectnode2 {
    private static Connection mysqlconn;
    public static Connection connectDB() throws SQLException {
        if(mysqlconn==null){
            try {
                String DB="jdbc:mysql://www.anisnode.com/db_blockchain"; // db_blockchain database
                String user="azzam"; // user database
                String pass="123"; // password database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlconn = (Connection) DriverManager.getConnection(DB,user,pass);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"gagal koneksi");
            }
        }
        return mysqlconn;
    }
}
