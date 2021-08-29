/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class Myconnection {
    public Connection koneksi = null;
    
    public Connection getConnection(){
        try{
      MysqlDataSource msds = new MysqlDataSource();
        msds.setServerName("localhost");
        msds.setPortNumber(3306);
        msds.setUser("root");
        msds.setPassword("");
        msds.setDatabaseName("kbm_mahasiswa");
        koneksi = msds.getConnection();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
      
        return koneksi;
    }
    
}
